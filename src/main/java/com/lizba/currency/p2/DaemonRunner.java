package com.lizba.currency.p2;

/**
 * <p>
 *      DaemonRunner线程
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/14 19:50
 */
public class DaemonRunner implements Runnable{
    @Override
    public void run() {
        try {
            SleepUtil.sleepSecond(100);
        } finally {
            System.out.println("DaemonRunner finally run ...");
        }
    }
}
