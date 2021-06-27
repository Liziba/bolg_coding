package com.lizba.currency.p1;

/**
 * <p>
 *      final 修饰引用类型变量
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/11 21:52
 */
public class FinalReferenceExample {

    /** final是引用类型 */
    final int[] intArray;
    static FinalReferenceExample obj;

    /**
     * 构造函数
     */
    public FinalReferenceExample() {
        this.intArray = new int[1];  // 1
        intArray[0] = 1;             // 2
    }

    /**
     * 写线程A执行
     */
    public static void writer1() {
        obj = new FinalReferenceExample();      // 3
    }

    /**
     * 写线程B执行
     */
    public static void writer2() {
        obj.intArray[0] = 2;                    // 4
    }

    /**
     * 读线程C执行
     */
    public static void reader() {
        if (obj != null) {                      // 5
            int temp = obj.intArray[0];         // 6
        }
    }
}
