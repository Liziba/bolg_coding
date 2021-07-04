package com.lizba.pattern.singleton.lazy;

/**
 * <p>
 *      内部类懒汉式单例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 20:14
 */
public class LazySingletonDemo8 {

    private LazySingletonDemo8() {
        if (LazyHolderInner.LAZY_SINGLETON != null) {
            throw new RuntimeException("This operation is forbidden.");
        }
    }

    public static LazySingletonDemo8 getInstance() {
        return LazyHolderInner.LAZY_SINGLETON;
    }

    private static class LazyHolderInner {
      public static final LazySingletonDemo8 LAZY_SINGLETON = new LazySingletonDemo8();
    }


}
