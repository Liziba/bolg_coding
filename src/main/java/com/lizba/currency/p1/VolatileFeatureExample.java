package com.lizba.currency.p1;

/**
 * <p>
 *      volatile示例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/9 21:34
 */
public class VolatileFeatureExample {

    /** 使用volatile声明64位的long型变量 */
    volatile long v1 = 0l;

    /**
     * 单个volatile写操作
     * @param l
     */
    public void set(long l) {
        v1 = l;
    }

    /**
     * 复合(多个)volatile读&写
     */
    public void getAndIncrement() {
        v1++;
    }

    /**
     * 单个volatile变量的读
     * @return
     */
    public long get() {
        return v1;
    }

}
