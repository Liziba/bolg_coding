package com.lizba.pattern.factory.factoryMethod;


import com.lizba.pattern.factory.IMobilePhone;
import com.lizba.pattern.factory.IPhone;

/**
 * <p>
 *  苹果手机生产工厂
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:55
 */
public class IPhonePhoneFactory implements IMakePhoneFactory{

    @Override
    public IMobilePhone makePhone() {
        return new IPhone();
    }
}
