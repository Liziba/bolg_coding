package com.lizba.pattern.singleton.hungry;

/**
 * <p>
 *      枚举式单例测试
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 20:33
 */
public class EnumSingletonTest {

    public static void main(String[] args) {
        EnumSingletonDemo instance1 = EnumSingletonDemo.getInstance();
        instance1.setObject(new Integer(100));

        EnumSingletonDemo instance2 = EnumSingletonDemo.getInstance();
        Integer value = (Integer) instance2.getObject();

        System.out.println(instance1 == instance2);
        System.out.println(value);
    }

}
