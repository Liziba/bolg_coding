package com.lizba.currency.p1;

/**
 * <p>
 *      死锁示例代码
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/5 0:37
 */
public class DeadLockDemo {


    private static final String A = "A";
    private static final String B = "B";

    /**
     * t1\t2互相持有锁
     */
    private void deadLock() {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                // 持有锁A
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 持有锁B
                    synchronized (B) {
                        System.out.println("hold Lock B");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                // 持有锁B
                synchronized (B) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 持有锁A
                    synchronized (A) {
                        System.out.println("hold Lock A");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

}
