package com.lizba.currency.p1;

/**
 * <p>
 *      双重检查锁
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/12 22:51
 */
public class DoubleCheckedLocking {

//    private static Instance instance;
    private volatile static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {                                 // 第一次检查
            synchronized (DoubleCheckedLocking.class) {         // 加锁
                if (instance == null) {                         // 第二次检查
                    instance = new Instance();                  // instance为volatile，问题得以解决
                }
            }
        }
        return instance;
    }

}
