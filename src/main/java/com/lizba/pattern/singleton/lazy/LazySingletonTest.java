package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *      测试懒汉式单例1的线程不安全
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 16:05
 */
public class LazySingletonTest {

    public static void main(String[] args) {
        new Thread(() -> run(), "Thread-1").start();
        new Thread(() -> run(), "Thread-2").start();

        System.out.println("End of test...");
    }


    public static void run() {
        LazySingletonDemo2 lad = LazySingletonDemo2.getInstance();
        System.out.println(Thread.currentThread().getName() + " : " + lad);
    }


}
