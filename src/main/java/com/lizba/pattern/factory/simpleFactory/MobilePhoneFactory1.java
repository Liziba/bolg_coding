package com.lizba.pattern.factory.simpleFactory;


import com.lizba.pattern.factory.IMobilePhone;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/29 10:12
 */
public class MobilePhoneFactory1 {


    public static IMobilePhone getMobilePhone(Class<? extends IMobilePhone> clz) {

        IMobilePhone phone = null;
        if (null != clz) {
            try {
                phone = clz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return phone;
    }
}
