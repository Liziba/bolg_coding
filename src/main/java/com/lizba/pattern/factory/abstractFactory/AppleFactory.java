package com.lizba.pattern.factory.abstractFactory;


import com.lizba.pattern.factory.ILaptop;
import com.lizba.pattern.factory.IMobilePhone;
import com.lizba.pattern.factory.IPhone;
import com.lizba.pattern.factory.MacBook;

/**
 * <p>
 *      苹果工厂
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 22:21
 */
public class AppleFactory implements AbstractFactory{


    @Override
    public ILaptop makeLaptop() {
        return new MacBook();
    }

    @Override
    public IMobilePhone makeMobilePhone() {
        return new IPhone();
    }
}
