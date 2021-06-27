package com.lizba.currency.p1;

/**
 * <p>
 *      实例工厂
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/12 23:52
 */
public class InstanceFactory {

    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance;
    }

}
