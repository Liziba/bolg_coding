package com.lizba.currency.p2;

/**
 * <p>
 *      线程中断示例代码
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/14 20:36
 */
public class Interrupted {

    public static void main(String[] args) {
        // sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "sleepThread");
        sleepThread.setDaemon(true);

        // busyThread
        Thread busyThread = new Thread(new BusyRunner(), "busyThread");
        busyThread.setDaemon(true);

        // 启动两个线程
        sleepThread.start();
        busyThread.start();

        // 休眠5秒，让sleepThread和busyThread运行充分
        SleepUtil.sleepSecond(5);

        // 中断两个线程
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

        // 睡眠主线程，防止daemon线程退出
        SleepUtil.sleepSecond(20);
    }

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtil.sleepSecond(10);
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {}
        }
    }

}
