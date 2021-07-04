package com.lizba.pattern.factory.factoryMethod;


import com.lizba.pattern.factory.IMobilePhone;
import com.lizba.pattern.factory.XiaomiPhone;

/**
 * <p>
 *      小米手机生产工厂
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:49
 */
public class XiaomiPhoneFactory implements IMakePhoneFactory{

    @Override
    public IMobilePhone makePhone() {
        return new XiaomiPhone();
    }

}
