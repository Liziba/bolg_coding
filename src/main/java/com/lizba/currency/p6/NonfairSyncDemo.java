package com.lizba.currency.p6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *      非公平锁测试
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/21 23:18
 */
public class NonfairSyncDemo {

    /*** 默认非公平锁 */
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runner(), "Thread-"+i).start();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "：获取了锁");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
