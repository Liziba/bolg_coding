package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 16:53
 */
public class LazySingletonDemo3 {

    private static LazySingletonDemo3 LAZY_SINGLETON = null;

    private LazySingletonDemo3() {
    }

    public static LazySingletonDemo3 getInstance() {
        synchronized (LazySingletonDemo3.class) {
            if (LAZY_SINGLETON == null) {
                LAZY_SINGLETON = new LazySingletonDemo3();
            }
            return LAZY_SINGLETON;
        }
    }

}
