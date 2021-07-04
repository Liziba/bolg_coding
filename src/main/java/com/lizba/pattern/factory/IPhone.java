package com.lizba.pattern.factory;

/**
 * <p>
 *      苹果手机
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:11
 */
public class IPhone implements IMobilePhone {

    @Override
    public void sendShortMessage() {
        System.out.println("IPhone phone send short message...");
    }

    @Override
    public void call() {
        System.out.println("IPhone phone call...");
    }
}
