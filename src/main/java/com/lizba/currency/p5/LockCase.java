package com.lizba.currency.p5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/19 21:03
 */
public class LockCase {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
        } finally {
            lock.unlock();
        }

    }

}
