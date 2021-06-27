package com.lizba.currency.p2;

/**
 * <p>
 *      标志位终止线程示例代码
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/14 21:17
 */
public class ShutDown {

    public static void main(String[] args) {
        Runner one = new Runner();
        Thread t = new Thread(one, "CountThread");
        t.start();
        SleepUtil.sleepSecond(1);
        t.interrupt();

        Runner two = new Runner();
        t = new Thread(two, "CountThread");
        t.start();
        SleepUtil.sleepSecond(1);
        two.cancel();
    }



    private static class Runner implements Runnable {

        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " +i);
        }

        /**
         * 关闭
         */
        public void cancel() {
            on = false;
        }
    }

}
