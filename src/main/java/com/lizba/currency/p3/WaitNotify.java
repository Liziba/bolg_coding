package com.lizba.currency.p3;

import com.lizba.currency.p2.SleepUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/15 23:28
 */
public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();
    static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "waitThread");
        waitThread.start();
        SleepUtil.sleepSecond(1);
        Thread notifyThread = new Thread(new Notify(), "notifyThread");
        notifyThread.start();
    }


    /**
     * wait线程，当条件不满足时wait()
     */
    static class Wait implements Runnable{

        @Override
        public void run() {
            // 加锁
            synchronized(lock) {
                // 当条件不满足时，继续wait
                while (flag) {
                    System.out.println(Thread.currentThread()
                            + " flag is true. wait at " +sdf.format(new Date()));
                    try {
                        // 此操作会释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 满足条件是完成工作
                System.out.println(Thread.currentThread()
                        + " flag is false. finished at " + sdf.format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            // 加锁
            synchronized (lock) {
                // 获取到锁或通知等待在锁上的线程
                // 通知不会释放锁，直到当前线程执行完释放lock锁后，waitThread才能从wait方法返回
                System.out.println(Thread.currentThread()
                        + "hold lock. notify at " + sdf.format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtil.sleepSecond(5);
            }
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread()
                        + "hold lock again. notify at " + sdf.format(new Date()));
                SleepUtil.sleepSecond(5);
            }
        }
    }

}
