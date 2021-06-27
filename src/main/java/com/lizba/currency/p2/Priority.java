package com.lizba.currency.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *      线程优先级设置
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/14 12:03
 */
public class Priority {

    /** 线程执行流程控制开关 */
    private static volatile boolean notStart = true;
    /** 线程执行流程控制开关 */
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        // 设置5个优先级为1的线程，设置5个优先级为10的线程
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        jobs.forEach(
                job -> System.out.println("Job priority : " + job.priority + ", Count : " + job.jobCount)
        );
    }


    /**
     * 通过Job来记录线程的执行次数和优先级
     */
    static class Job implements Runnable {

        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                // 让出CPU时间片，等待下次调度
                Thread.yield();
            }
            while (notEnd) {
                // 让出CPU时间片，等待下次调度
                Thread.yield();
                jobCount++;
            }
        }
    }

}
