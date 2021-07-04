package com.lizba.pattern.factory.abstractFactory;


import com.lizba.pattern.factory.HuaweiPhone;
import com.lizba.pattern.factory.ILaptop;
import com.lizba.pattern.factory.IMobilePhone;
import com.lizba.pattern.factory.MagicBook;

/**
 * <p>
 *      华为工厂 -- 产品族
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 22:18
 */
public class HuaweiFactory implements AbstractFactory{

    @Override
    public ILaptop makeLaptop() {
        return new MagicBook();
    }

    @Override
    public IMobilePhone makeMobilePhone() {
        return new HuaweiPhone();
    }
}
