package com.lizba.currency.p2;

/**
 * <p>
 *      线程状态示例代码
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/14 13:25
 */
public class ThreadStateDemo {

    public static void main(String[] args) {
        // TimeWaiting
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        // Waiting
        new Thread(new Waiting(), "WaitingThread").start();
        // Blocked1和Blocked2一个获取锁成功，一个获取失败
        new Thread(new Blocked(), "Blocked1Thread").start();
        new Thread(new Blocked(), "Blocked2Thread").start();
    }

    // 线程不断的进行睡眠
    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtil.sleepSecond(100);
            }
        }
    }

    // 线程等待在Waiting.class实例上
    static class Waiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 该线程Blocked.class实例上加锁，不会释放该锁
    static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtil.sleepSecond(100);
                }
            }
        }
    }



}
