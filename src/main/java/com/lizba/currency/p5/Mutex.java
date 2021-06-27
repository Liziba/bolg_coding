package com.lizba.currency.p5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <p>
 *      自定义独占锁
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/19 22:40
 */
public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 尝试获取锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            // 当前状态如果为0则获取到锁
            if (compareAndSetState(0, 1)) {
                // 设置锁的占用线程为当线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 尝试释放锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            // 如果当前同步状态为0，调用该方法则抛出异常
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            // 清空占用线程
            setExclusiveOwnerThread(null);
            // 设置共享状态为0
            setState(0);
            return true;
        }

        /**
         * 判断当前线程是否处于占用状态
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 返回一个Condition，每个Condition包含一个condition队列
         *
         * @return
         */
        Condition condition() {
            return new ConditionObject();
        }
    }

    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.condition();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }
}
