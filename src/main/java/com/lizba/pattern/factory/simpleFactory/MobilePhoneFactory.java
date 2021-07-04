package com.lizba.pattern.factory.simpleFactory;


import com.lizba.pattern.factory.HuaweiPhone;
import com.lizba.pattern.factory.IMobilePhone;
import com.lizba.pattern.factory.IPhone;
import com.lizba.pattern.factory.XiaomiPhone;

/**
 * <p>
 *  手机简单工厂
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:14
 */
public class MobilePhoneFactory {

    public static IMobilePhone getMobilePhone(PhoneTypeEnum phoneType) {

        IMobilePhone phone = null;
        switch (phoneType) {
            case HUAWEI:
                phone = new HuaweiPhone();
                break;
            case XIAOMI:
                phone = new XiaomiPhone();
                break;
            case IPHONE:
                phone = new IPhone();
                break;
            default:
                break;
        }
        return phone;
    }


     enum PhoneTypeEnum {

        HUAWEI("华为", "A"),
        XIAOMI("小米", "B"),
        IPHONE("苹果", "C");

         private String name;
         private String value;

         PhoneTypeEnum(String name, String value) {
             this.name = name;
             this.value = value;
         }
    }

}
