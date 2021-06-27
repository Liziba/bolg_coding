package com.lizba.currency.p1;

/**
 * <p>
 *      volatile屏障示例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/9 23:48
 */
public class VolatileBarrierExample {

    int a;
    volatile int v1 = 1;
    volatile int v2 = 2;

    void readAndWrite() {
        // 第一个volatile读
        int i = v1;
        // 第二个volatile读
        int j = v2;
        // 普通写
        a = i + j;
        // 第一个volatile写
        v1 = i + 1;
        // 第二个volatile写
        v2 = j * 2;
    }

    // ... 其他方法

}
