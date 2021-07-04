package com.lizba.pattern.factory;

/**
 * <p>
 * 小米手机
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:10
 */
public class XiaomiPhone implements IMobilePhone {

    @Override
    public void sendShortMessage() {
        System.out.println("Xiaomi phone send short message...");
    }

    @Override
    public void call() {
        System.out.println("Xiaomi phone call...");
    }
}
