package com.lizba.currency.p1;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/12 22:46
 */
public class SafeLazyInitialization {

    private static Instance instance;

    public synchronized static Instance getInstance() {
        if (instance == null) {             // 线程A执行
            instance = new Instance();      // 线程B执行
        }
        return instance;
    }

}
