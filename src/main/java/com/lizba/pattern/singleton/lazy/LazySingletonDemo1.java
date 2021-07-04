package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *        简单懒汉式单例示例代码1
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 16:01
 */
public class LazySingletonDemo1 {

    private static LazySingletonDemo1 LAZY_SINGLETON = null;

    private LazySingletonDemo1() {
    }

    public static LazySingletonDemo1 getInstance() {
        if (LAZY_SINGLETON == null) {
            LAZY_SINGLETON = new LazySingletonDemo1();
        }
        return LAZY_SINGLETON;
    }
}
