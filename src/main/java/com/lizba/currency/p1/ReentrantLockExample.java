package com.lizba.currency.p1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/10 22:17
 */
public class ReentrantLockExample {

    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock();                 // 获取锁
        try {
            a++;
        } finally {
            lock.unlock();          // 释放锁
        }
    }

    public void reader() {
        lock.lock();                // 获取锁
        try {
            int i = a;
            System.out.println(i);
        } finally {
            lock.unlock();          // 释放锁
        }
    }

}
