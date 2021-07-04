package com.lizba.pattern.singleton.hungry;

/**
 * <p>
 *  枚举式单例示例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 20:29
 */
public enum  EnumSingletonDemo {

    SINGLETON_INSTANCE;
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static EnumSingletonDemo getInstance() {
        return SINGLETON_INSTANCE;
    }
}
