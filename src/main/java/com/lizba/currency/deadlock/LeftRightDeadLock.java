package com.lizba.currency.deadlock;

/**
 * <p>
 *     顺序死锁
 * </p>
 *
 * @Author: Liziba
 */
public class LeftRightDeadLock {

    private final Object right = new Object();
    private final Object left = new Object();

    /**
     * 加锁顺序从left -> right
     */
    public void leftToRight() {
        synchronized (left) {
            synchronized (right) {
                System.out.println(Thread.currentThread().getName() + " left -> right lock.");
            }
        }
    }

    /**
     * 加锁顺序right -> left
     */
    public void rightToLeft() {
        synchronized (right) {
            synchronized (left) {
                System.out.println(Thread.currentThread().getName() + " right -> left lock.");
            }
        }
    }

    public static void main(String[] args) {
        LeftRightDeadLock lrDeadLock = new LeftRightDeadLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 为了更好的演示死锁，将两个方法的调用放置到同一个线程中执行
                lrDeadLock.leftToRight();
                lrDeadLock.rightToLeft();
            }, "ThreadA-"+i).start();
        }
    }

}
