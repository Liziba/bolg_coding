package com.lizba.currency.p5;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/19 22:00
 */
public abstract class AbstractQueuedSynchronizer1 extends AbstractOwnableSynchronizer
        implements java.io.Serializable {


    /**
     * 独占式获取同步状态，实现该方法需要查询当前状态并且判断同步状态是否符合预期，然后再进行CAS设置同步状态
     *
     * @param arg
     * @return
     */
    protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }

    /**
     * 独占式释放同步状态，等待获取同步状态的线程将会有机会获取同步状态
     *
     * @param arg
     * @return
     */
    protected boolean tryRelease(int arg) {
        throw new UnsupportedOperationException();
    }

    /**
     * 共享式获取同步状态，返回大于等于0的值，表示获取成功，反正获取失败
     *
     * @param arg
     * @return
     */
    protected int tryAcquireShared(int arg) {
        throw new UnsupportedOperationException();
    }


    /**
     * 共享式释放同步状态
     *
     * @param arg
     * @return
     */
    protected boolean tryReleaseShared(int arg) {
        throw new UnsupportedOperationException();
    }

    /**
     * 当前同步器释放在独占模式下被线程占用，一般该方法表示释放被当前线程所占
     *
     * @return
     */
    protected boolean isHeldExclusively() {
        throw new UnsupportedOperationException();
    }


//    /**
//     * 独占式获取同步状态，如果当前线程获取同步状态成功，则由该方法返回；
//     * 否则，将会进入同步等待队列等待，该方法将会调用重写的tryAcquire(int arg)方法
//     *
//     * @param arg
//     */
//    public final void acquire(int arg) {
//        if (!tryAcquire(arg) &&
//                acquireQueued(addWaiter(java.util.concurrent.locks.AbstractQueuedSynchronizer.Node.EXCLUSIVE), arg))
//            selfInterrupt();
//    }
//
//    /**
//     * 与acquire方法相同，但是该方法可以响应中断，当前线程未获取到同步状态进入同步队列中
//     * 如果当前线程被中断，则该方法抛出InterruptedException异常
//     *
//     * @param arg
//     * @throws InterruptedException
//     */
//    public final void acquireInterruptibly(int arg)
//            throws InterruptedException {
//        if (Thread.interrupted())
//            throw new InterruptedException();
//        if (!tryAcquire(arg))
//            doAcquireInterruptibly(arg);
//    }
//
//    /**
//     * 在acquireInterruptibly方法的基础上增加了超时限制
//     * 如果当前线程在超时时间内未获取到同步状态，则返回false，获取到则返回true
//     *
//     * @param arg
//     * @param nanosTimeout
//     * @return
//     * @throws InterruptedException
//     */
//    public final boolean tryAcquireNanos(int arg, long nanosTimeout)
//            throws InterruptedException {
//        if (Thread.interrupted())
//            throw new InterruptedException();
//        return tryAcquire(arg) ||
//                doAcquireNanos(arg, nanosTimeout);
//    }
//
//    /**
//     * 共享式额获取同步状态，如果当前线程未获取到同步状态，将会进入同步队列等待
//     * 与独占式获取的主要区别是在同一时刻可以由多个线程同时获取到同步状态
//     *
//     * @param arg
//     */
//    public final void acquireShared(int arg) {
//        if (tryAcquireShared(arg) < 0)
//            doAcquireShared(arg);
//    }
//
//
//    /**
//     * 与acquireShared方法相同，该方法响应中断
//     *
//     * @param arg
//     * @throws InterruptedException
//     */
//    public final void acquireSharedInterruptibly(int arg)
//            throws InterruptedException {
//        if (Thread.interrupted())
//            throw new InterruptedException();
//        if (tryAcquireShared(arg) < 0)
//            doAcquireSharedInterruptibly(arg);
//    }
//
//    /**
//     * 在acquireSharedInterruptibly的基础上增加了超时限制
//     *
//     * @param arg
//     * @param nanosTimeout
//     * @return
//     * @throws InterruptedException
//     */
//    public final boolean tryAcquireSharedNanos(int arg, long nanosTimeout)
//            throws InterruptedException {
//        if (Thread.interrupted())
//            throw new InterruptedException();
//        return tryAcquireShared(arg) >= 0 ||
//                doAcquireSharedNanos(arg, nanosTimeout);
//    }
//
//    /**
//     * 独占式的释放同步状态，该方法会在释放同步状态之后，将同步队列中第一个节点包含的线程唤醒
//     *
//     * @param arg
//     * @return
//     */
//    public final boolean release(int arg) {
//        if (tryRelease(arg)) {
//            java.util.concurrent.locks.AbstractQueuedSynchronizer.Node h = head;
//            if (h != null && h.waitStatus != 0)
//                unparkSuccessor(h);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 共享式的释放同步状态
//     *
//     * @param arg
//     * @return
//     */
//    public final boolean releaseShared(int arg) {
//        if (tryReleaseShared(arg)) {
//            doReleaseShared();
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     *  获取等待在同步队列上的线程集合
//     *
//     * @return
//     */
//    public final Collection<Thread> getQueuedThreads() {
//        ArrayList<Thread> list = new ArrayList<Thread>();
//        for (java.util.concurrent.locks.AbstractQueuedSynchronizer.Node p = tail; p != null; p = p.prev) {
//            Thread t = p.thread;
//            if (t != null)
//                list.add(t);
//        }
//        return list;
//    }


}
