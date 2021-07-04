package com.lizba.pattern.factory.simpleFactory;


import com.lizba.pattern.factory.IMobilePhone;

/**
 * <p>
 *      简单工厂测试
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:40
 */
public class Test {

    public static void main(String[] args) {

        // 华为手机
        IMobilePhone phone = MobilePhoneFactory.getMobilePhone(MobilePhoneFactory.PhoneTypeEnum.HUAWEI);
        phone.sendShortMessage();
        phone.call();

        // 小米手机
        phone = MobilePhoneFactory.getMobilePhone(MobilePhoneFactory.PhoneTypeEnum.XIAOMI);
        phone.sendShortMessage();
        phone.call();

        // 苹果手机
        phone = MobilePhoneFactory.getMobilePhone(MobilePhoneFactory.PhoneTypeEnum.IPHONE);
        phone.sendShortMessage();
        phone.call();

    }

}
