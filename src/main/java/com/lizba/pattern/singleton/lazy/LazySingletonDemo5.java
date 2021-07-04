package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *      双重检查锁
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 17:04
 */
public class LazySingletonDemo5 {

    private static LazySingletonDemo5 LAZY_SINGLETON = null;

    private LazySingletonDemo5() {
    }

    public static LazySingletonDemo5 getInstance() {
        // 检查1
        if (LAZY_SINGLETON == null) {
            synchronized (LazySingletonDemo5.class) {
                // 检查2（这就是双重检查）
                if (LAZY_SINGLETON == null) {
                    LAZY_SINGLETON = new LazySingletonDemo5();
                }
            }
        }
        return LAZY_SINGLETON;
    }

}
