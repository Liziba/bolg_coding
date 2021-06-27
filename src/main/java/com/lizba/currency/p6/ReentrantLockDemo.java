package com.lizba.currency.p6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *      ReentrantLock使用示例代码
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/21 22:09
 */
public class ReentrantLockDemo {

    /**　初始化一个非公平锁，ReentrantLock的默认实现是非公平锁　*/
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(() -> testReentrantLock(), "Thread A").start();
        new Thread(() -> testReentrantLock(), "Thread B").start();

    }

    /**
     * 假设为获取锁执行的相关业务逻辑方法
     */
    private static void testReentrantLock() {
        // 获取锁要在try值外，如果获取锁过程中异常，不会无故释放锁
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "：获取了锁");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁在finally代码块中
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "：释放了锁");
        }
    }


}
