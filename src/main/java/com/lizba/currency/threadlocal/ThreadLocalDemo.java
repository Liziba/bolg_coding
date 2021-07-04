package com.lizba.currency.threadlocal;

/**
 * <p>
 *      ThreadLocal demo -> 线程隔离
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/2 15:47
 */
public class ThreadLocalDemo {

    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> Integer.valueOf(10));

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> run(), "Thread-" + i).start();
        }
        
    }

    public static void run() {
        ThreadLocalDemo local = new ThreadLocalDemo();
        local.threadLocal.set(local.threadLocal.get() + 5);
        System.out.println(Thread.currentThread().getName() +" : "+local.threadLocal.get());
    }


}
