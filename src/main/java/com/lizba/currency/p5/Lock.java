package com.lizba.currency.p5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public interface Lock {

    /**
     * 获取锁；调用该方法的线程将会获取锁，当获取到锁后，从该方法返回
     */
    void lock();

    /**
     * 可以中断的获取锁，和Lock方法先比不同之处在于该方法可以响应中断，即在锁获取的过程中可以中断当前线程
     *
     * @throws InterruptedException
     */
    void lockInterruptibly() throws InterruptedException;

    /**
     * 尝试非阻塞的获取锁，调用该方法后立即返回，如果能够获取则返回true，否则返回false
     *
     * @return
     */
    boolean tryLock();

    /**
     * 超时获取锁，如下情况会返回：
     * 1、当前线程在指定超时时间内获取到锁
     * 2、当前线程在超时时间内被中断
     * 3、超时时间结束，返回false
     *
     * @param time
     * @param unit
     * @return
     * @throws InterruptedException
     */
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    /**
     * 释放锁
     */
    void unlock();

    /**
     * 获取等待通知组件，该组件和当前的锁绑定，当前线程只有获取了锁，才能调用该组件的wait()方法，而调用后，当前线程会释放锁
     *
     * @return
     */
    Condition newCondition();
}