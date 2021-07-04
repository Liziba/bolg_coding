package com.lizba.pattern.factory.factoryMethod;


import com.lizba.pattern.factory.IMobilePhone;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:56
 */
public class Test {

    public static void main(String[] args) {

        IMobilePhone phone = new HuaweiPhoneFactory().makePhone();
        phone.call();
        phone.sendShortMessage();

        phone = new XiaomiPhoneFactory().makePhone();
        phone.call();
        phone.sendShortMessage();

    }

}
