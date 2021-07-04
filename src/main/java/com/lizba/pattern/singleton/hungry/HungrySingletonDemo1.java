package com.lizba.pattern.singleton.hungry;

/**
 * <p>
 *      饿汉式单例写法一
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 15:46
 */
public class HungrySingletonDemo1 {

    private static final HungrySingletonDemo1 HUNGRY_SINGLETON_DEMO_1 = new HungrySingletonDemo1();

    private HungrySingletonDemo1() {}

    public static HungrySingletonDemo1 getInstance() {
        return HUNGRY_SINGLETON_DEMO_1;
    }

}
