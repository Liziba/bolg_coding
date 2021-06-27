package com.lizba.currency.p1;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/11 20:37
 */
public class FinalExample {

    /** 普通变量 */
    int i;
    /** final变量 */
    final int j;
    /** 对象引用 */
    static FinalExample obj;

    /**
     * 构造函数
     */
    public FinalExample() {
        // 写普通域
        this.i = 1;
        // 写final域
        this.j = 2;
    }

    /**
     * 线程A执行writer写方法
     *
     */
    public static void writer() {
        obj = new FinalExample();
    }

    /**
     * 线程B执行reader读方法
     *
     */
    public static void reader() {
        // 读对象的引用
        FinalExample finalExample = obj;
        // 读普通域
        int a = finalExample.i;
        // 读final域
        int b = finalExample.j;
    }
}
