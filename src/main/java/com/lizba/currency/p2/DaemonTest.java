package com.lizba.currency.p2;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/14 19:59
 */
public class DaemonTest {

    public static void main(String[] args) {
        Thread t = new Thread(new DaemonRunner(), "DaemonRunner");
        t.setDaemon(true);
        t.start();
    }

}
