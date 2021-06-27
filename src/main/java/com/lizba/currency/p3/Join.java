package com.lizba.currency.p3;

import com.lizba.currency.p2.SleepUtil;

/**
 * <p>
 *      设置十个线程，分别从0-9，每个线程需要调用前一个线程的join()方法
 *      比如线程0结束了，线程1才能从join()返回
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/16 21:25
 */
public class Join {

    public static void main(String[] args) {
        // 前一个线程
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Domino(previous), String.valueOf(i));
            t.start();
            previous = t;
        }
        SleepUtil.sleepSecond(5);
        System.out.println(Thread.currentThread().getName() + " end.");

    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        }
    }


}
