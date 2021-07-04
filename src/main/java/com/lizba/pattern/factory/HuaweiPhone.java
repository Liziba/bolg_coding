package com.lizba.pattern.factory;

/**
 * <p>
 * 华为手机
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 17:09
 */
public class HuaweiPhone implements IMobilePhone {

    @Override
    public void sendShortMessage() {
        System.out.println("Huawei phone send short message...");
    }

    @Override
    public void call() {
        System.out.println("Huawei phone call...");
    }
}
