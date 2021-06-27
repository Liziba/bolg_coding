package com.lizba.currency.p3;

/**
 * <p>
 *      简单通知
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/15 23:10
 */
public class SimpleNotify {

   public static volatile boolean flag = Boolean.FALSE;
    
    public static void main(String[] args) throws InterruptedException {
        while (flag) {
            Thread.sleep(1000);
        }
        doSomething();
    }

    private static void doSomething() {
    }

}
