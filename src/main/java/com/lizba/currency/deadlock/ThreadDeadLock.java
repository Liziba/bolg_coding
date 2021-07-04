package com.lizba.currency.deadlock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>
 *      单线程Executor中任务发送死锁
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/1 21:25
 */
public class ThreadDeadLock {

    /** 单个线程的线程池 */
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static class Task1 implements Callable<String> {

        @Override
        public String call() throws Exception {

            Future<String> first = executorService.submit(new Task2());
            Future<String> second = executorService.submit(new Task2());
            // 当前任务等待子任务的结果，但是两个子任务在等待主任务完成，导致死锁
            return first.get() + second.get();
        }
    }

    public static class Task2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "Hello Java";
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        executorService.submit(new Task1());
    }

}
