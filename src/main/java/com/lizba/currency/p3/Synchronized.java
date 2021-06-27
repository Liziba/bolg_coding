package com.lizba.currency.p3;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/15 22:13
 */
public class Synchronized {

    public static void main(String[] args) {

        // 同步代码块
        synchronized (Synchronized.class) {

        }
        // 静态方法
        method();
    }

    public static synchronized void method() {}

}
