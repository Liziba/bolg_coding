package com.lizba.currency.p1;

/**
 * <p>
 *      延迟初始化
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/12 22:40
 */
public class UnsafeLazyInitialization {

    private static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {             // 线程A执行
            instance = new Instance();      // 线程B执行
        }
        return instance;
    }

}
