package com.lizba.pattern.factory.abstractFactory;

import com.lizba.pattern.factory.ILaptop;
import com.lizba.pattern.factory.IMobilePhone;
/**
 * <p>
 *      抽象工厂
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 22:17
 */
public interface AbstractFactory {

    /**
     * 生产笔记本电脑
     * @return
     */
    ILaptop makeLaptop();

    /**
     * 生产手机
     * @return
     */
    IMobilePhone makeMobilePhone();

}
