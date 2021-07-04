package com.lizba.pattern.factory.abstractFactory;


import com.lizba.pattern.factory.ILaptop;
import com.lizba.pattern.factory.IMobilePhone;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 22:23
 */
public class Test {

    public static void main(String[] args) {

        AbstractFactory factory = new HuaweiFactory();
        ILaptop laptop = factory.makeLaptop();
        laptop.coding();
        IMobilePhone phone = factory.makeMobilePhone();
        phone.call();

    }

}
