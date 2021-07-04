package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *      防止反射破坏单例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 17:56
 */
public class LazySingletonDemo7 {

    private static volatile LazySingletonDemo7 LAZY_SINGLETON = null;

    private LazySingletonDemo7() {
        if (LAZY_SINGLETON != null) {
            throw new RuntimeException("This operation is forbidden.");
        }
    }

    public static LazySingletonDemo7 getInstance() {
        // 检查1
        if (LAZY_SINGLETON == null) {
            synchronized (LazySingletonDemo7.class) {
                // 检查2（这就是双重检查）
                if (LAZY_SINGLETON == null) {
                    LAZY_SINGLETON = new LazySingletonDemo7();
                }
            }
        }
        return LAZY_SINGLETON;
    }


}
