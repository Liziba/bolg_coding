package com.lizba.currency.p6;

import org.omg.CORBA.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *      使用Condition来实现的一个有界队列示例代码
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/26 16:03
 */
public class ConditionBoundedBuffer<E> {

    /** 定义数组做有界队列容器 */
    final E[] items;
    /** 可重入锁ReentrantLock() */
    final Lock lock = new ReentrantLock();
    /** 条件：数组不满  notFull ( count < item.length) */
    final Condition notFull = lock.newCondition();
    /** 条件：数组不为空 notEmpty ( count > 0) */
    final Condition notEmpty = lock.newCondition();
    /**
     * tail游标，记录当前插入元素到了哪个位置
     * head游标，记录当前获取元素到了哪个位置
     * count，记录容器中的元素的个数
     * */
    private int tail, head, count;

    public ConditionBoundedBuffer(int size) {
        this.items = (E[]) new Object[size];
    }

    /**
     * 添加元素操作
     * @param e
     * @throws InterruptedException
     */
    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[tail] = e;
            if (++tail == items.length) {
                tail = 0;
            }
            ++count;
            notEmpty.signalAll();
        } finally {
          lock.unlock();
        }
    }


    /**
     * 获取元素操作
     * @return
     * @throws InterruptedException
     */
    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            E ret = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            --count;
            notFull.signalAll();
            return ret;
        } finally {
            lock.unlock();
        }
    }

}
