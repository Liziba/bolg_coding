package com.lizba.pattern.singleton.hungry;

import java.lang.reflect.Constructor;

/**
 * <p>
 *      反射尝试破坏枚举式单例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 20:56
 */
public class EnumSingletonTest2 {

    public static void main(String[] args) {
        Class<EnumSingletonDemo> clazz = EnumSingletonDemo.class;
        try {
            // 为何是这两个参数不明白的可以看上面jad生成的代码
            Constructor<EnumSingletonDemo> c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            EnumSingletonDemo enumSingletonDemo = c.newInstance("liziba", "liziba_98");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
