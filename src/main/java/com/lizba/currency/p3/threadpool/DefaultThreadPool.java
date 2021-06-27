package com.lizba.currency.p3.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/17 22:34
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    /** 线程池最大工作者线程数量 */
    private static final int MAX_WORKER_SIZE = 20;
    /** 线程池默认工作者线程数量 */
    private static final int DEFAULT_WORKER_SIZE = 5;
    /** 线程池最小工作者线程数量 */
    private static final int MIN_WORKER_SIZE = 5;
    /** 工作队列，也称任务队列，用来存放客户端提交的任务 */
    private final LinkedList<Job> jobs = new LinkedList<>();
    /** 工作者列表，需要具有同步性质，支持并发操作 */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    /** 工作线程的数量 */
    private int workerNum = DEFAULT_WORKER_SIZE;
    /** 线程编号生成器 */
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initWorker(DEFAULT_WORKER_SIZE);
    }

    public DefaultThreadPool(int size) {
        initWorker(size);
    }

    /**
     * 初始化线程工作者，并启动
     *
     * @param size  初始化工作着大小
     */
    private void initWorker(int size) {
        for (int i = 0; i < size; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            // 添加一个任务，然后通知等待在jobs上的worker
            synchronized (jobs) {
                jobs.add(job);
                jobs.notifyAll();
            }
        }
    }

    @Override
    public void shutdown() {
        workers.forEach(worker -> worker.shutdown());
    }

    @Override
    public void addWorkers(int num) {
        // 此处要锁住jobs，因为worker会从jobs获取任务，需要jobs通知等待中的worker
        synchronized (jobs) {
            // 不允许工作者线程数操作最大值
            if (num + this.workerNum > MAX_WORKER_SIZE) {
                num = MAX_WORKER_SIZE - this.workerNum;
            }
            initWorker(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorkers(int num) {
        synchronized (jobs) {
            if (num > this.workerNum) {
                throw new IllegalArgumentException("超出工作者数目！");
            }

            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                // 如果移除成功则关闭工作者，工作者将不会继续获取任务执行
                if (workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
                this.workerNum -= count;
            }
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }



    /**
     * <p>
     *      工作者-负责消费客户端提交的任务
     * </p>
     *
     * @Author: Liziba
     * @Date: 2021/6/17 22:41
     */
    class Worker implements Runnable {

        /** 是否工作 */
        private volatile boolean running = Boolean.TRUE;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 如果感应到外部的中断通知，则自己主动中断返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // 取出任务队列的第一个任务
                    job = jobs.removeFirst();
                }
                // 执行任务
                if (job != null) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        job.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 关闭worker,全部关闭意味着线程池关闭
         */
        public void shutdown() {
            running = false;
        }
    }
}
