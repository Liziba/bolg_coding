package com.lizba.currency.p2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *      线程过期方法示例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/14 20:57
 */
public class Deprecated {


    static DateFormat format = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        Thread printThread = new Thread(new PrintThread(), "PrintThread");
        printThread.start();
        SleepUtil.sleepSecond(3);

        // 暂停printThread输出
        printThread.suspend();
        System.out.println("main suspend PrintThread at " + format.format(new Date()));
        SleepUtil.sleepSecond(3);

        // 恢复printThread输出
        printThread.resume();
        System.out.println("main resume PrintThread at " + format.format(new Date()));
        SleepUtil.sleepSecond(3);

        // 终止printThread输出
        printThread.stop();
        System.out.println("main stop PrintThread at " + format.format(new Date()));
        SleepUtil.sleepSecond(3);
    }


    static class PrintThread implements Runnable {

        @Override
        public void run() {
           while (true) {
               System.out.println(Thread.currentThread().getName() + "Run at "
               + format.format(new Date()));
               SleepUtil.sleepSecond(1);
           }
        }
    }

}
