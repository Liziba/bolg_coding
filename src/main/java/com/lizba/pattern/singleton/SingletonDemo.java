package com.lizba.pattern.singleton;

/**
 * <p>
 *      单例模式的简单使用示例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 14:44
 */
public class SingletonDemo {

    private static final SingletonDemo singleton = new SingletonDemo();

    private SingletonDemo() {}

    public static SingletonDemo getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        SingletonDemo.getInstance();
    }

}
