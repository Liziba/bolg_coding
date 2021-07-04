package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *      volatile修饰 LAZY_SINGLETON禁止指令重排序
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 17:12
 */
public class LazySingletonDemo6 {

    private static volatile LazySingletonDemo6 LAZY_SINGLETON = null;

    private LazySingletonDemo6() {
    }

    public static LazySingletonDemo6 getInstance() {
        // 检查1
        if (LAZY_SINGLETON == null) {
            synchronized (LazySingletonDemo6.class) {
                // 检查2（这就是双重检查）
                if (LAZY_SINGLETON == null) {
                    LAZY_SINGLETON = new LazySingletonDemo6();
                }
            }
        }
        return LAZY_SINGLETON;
    }

}
