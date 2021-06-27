package com.lizba.currency.p6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * <p>
 *      公平和非公平锁测试
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/21 23:33
 */
public class FairAndUnfairTest {

    /** 定义公平锁 */
    private static Lock fairLock = new ReentrantLockCustomize(true);
    /** 定义非公平锁 */
    private static Lock unfairLock = new ReentrantLockCustomize(false);

    public static void main(String[] args) {

//        testFairAndUnfairLock(fairLock);
        testFairAndUnfairLock(unfairLock);
    }


    /**
     * 测试公平锁和非公平锁
     * @param lock
     */
    private static void testFairAndUnfairLock(Lock lock) {
        for (int i = 1; i <= 5; i++) {
            new Job(lock, ""+i).start();
        }
    }


    /**
     * 定义线程实现，打印当前线程和等待队列中的线程
     */
    private static class Job extends Thread {

        private Lock lock;

        public Job(Lock lock,String name) {
            this.lock = lock;
            setName(name);
        }

        @Override
        public void run() {

            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    System.out.println("获取锁的线程：" + Thread.currentThread().getName());
                    System.out.println("同步队列中的线程：" + ((ReentrantLockCustomize)lock).getQueuedThreads().stream().map(t -> t.getName()).collect(Collectors.joining(",")));
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * 自定义可重入锁，主要新增getQueuedThreads()方法，用于获取等待队列中的线程
     */
    private static class ReentrantLockCustomize extends ReentrantLock {

        public ReentrantLockCustomize(boolean fair) {
            super(fair);
        }

        /**
         * 返回正在等待获取锁的线程列表，获取的实现列表逆序输出，反转后则为FIFO队列的原本顺序
         *
         * @return 等待队列中的线程顺序集合
         */
        public Collection<Thread> getQueuedThreads() {
            List<Thread> ts = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(ts);
            return ts;
        }
    }


}
