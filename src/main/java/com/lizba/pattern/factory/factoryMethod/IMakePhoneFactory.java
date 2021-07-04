package com.lizba.pattern.factory.factoryMethod;


import com.lizba.pattern.factory.IMobilePhone;

/**
 * <p>
 *      手机生产工厂接口
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:47
 */
public interface IMakePhoneFactory {

    /**
     * 生产手机的方法定义
     * @return
     */
    IMobilePhone makePhone();
}
