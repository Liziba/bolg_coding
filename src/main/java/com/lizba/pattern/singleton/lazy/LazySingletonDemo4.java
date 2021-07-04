package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *      if(LAZY_SINGLETON == null)前置于同步代码块，单例模式示例4
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 16:56
 */
public class LazySingletonDemo4 {

    private static LazySingletonDemo4 LAZY_SINGLETON = null;

    private LazySingletonDemo4() {
    }

    public static LazySingletonDemo4 getInstance() {
        // 前置if判断
        if (LAZY_SINGLETON == null) {
            synchronized (LazySingletonDemo4.class) {
                LAZY_SINGLETON = new LazySingletonDemo4();
            }
        }
        return LAZY_SINGLETON;
    }

}
