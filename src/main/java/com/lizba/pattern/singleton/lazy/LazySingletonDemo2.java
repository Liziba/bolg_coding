package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *      synchronized懒汉式单例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 16:37
 */
public class LazySingletonDemo2 {

    private static LazySingletonDemo2 LAZY_SINGLETON = null;

    private LazySingletonDemo2() {
    }

    public static synchronized LazySingletonDemo2 getInstance() {
        if (LAZY_SINGLETON == null) {
            LAZY_SINGLETON = new LazySingletonDemo2();
        }
        return LAZY_SINGLETON;
    }

}
