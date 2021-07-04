package com.lizba.pattern.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * <p>
 *      破坏双重检查锁单例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 17:34
 */
public class DoubleCheckTest {

    public static void main(String[] args) {
        Class<LazySingletonDemo7> singletonClass = LazySingletonDemo7.class;
        try {
            Constructor<LazySingletonDemo7> c = singletonClass.getDeclaredConstructor(null);
            // 破坏private访问权限
            c.setAccessible(true);
            LazySingletonDemo7 lsd1 = c.newInstance();
            LazySingletonDemo7 lsd2 = c.newInstance();

            System.out.println(lsd1 == lsd2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
