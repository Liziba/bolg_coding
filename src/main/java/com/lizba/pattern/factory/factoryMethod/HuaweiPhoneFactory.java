package com.lizba.pattern.factory.factoryMethod;


import com.lizba.pattern.factory.HuaweiPhone;
import com.lizba.pattern.factory.IMobilePhone;

/**
 * <p>
 * 华为手机生产工厂
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:50
 */
public class HuaweiPhoneFactory implements IMakePhoneFactory{

    @Override
    public IMobilePhone makePhone() {
        return new HuaweiPhone();
    }

}
