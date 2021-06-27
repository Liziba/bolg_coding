package com.lizba.currency.p1;

/**
 * <p>
 *      锁
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/10 21:43
 */
public class MonitorExample {

    int a = 0;

    public synchronized void writer() {     // 1;
        a++;                                // 2;
    }                                       // 3;

    public synchronized void reader() {     // 4;
        int i = a;                          // 5;
        System.out.println(i);
    }                                       // 6;

}
