package com.lizba.pattern.singleton.hungry;

/**
 * <p>
 *      饿汉式单例写法二
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 15:49
 */
public class HungrySingletonDemo2 {

    private static final HungrySingletonDemo2 HUNGRY_SINGLETON_DEMO_2;

    static {
        HUNGRY_SINGLETON_DEMO_2 = new HungrySingletonDemo2();
    }

    public static HungrySingletonDemo2 getInstance() {
        return HUNGRY_SINGLETON_DEMO_2;
    }

}
