package com.lizba.pattern.factory.abstractFactory;


import com.lizba.pattern.factory.ILaptop;
import com.lizba.pattern.factory.IMobilePhone;
import com.lizba.pattern.factory.XiaoMiPC;
import com.lizba.pattern.factory.XiaomiPhone;

/**
 * <p>
 *      小米工厂
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 22:20
 */
public class XiaomiFactory implements AbstractFactory{

    @Override
    public ILaptop makeLaptop() {
        return new XiaoMiPC();
    }

    @Override
    public IMobilePhone makeMobilePhone() {
        return new XiaomiPhone();
    }
}
