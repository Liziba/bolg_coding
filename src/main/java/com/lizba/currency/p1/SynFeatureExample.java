package com.lizba.currency.p1;

/**
 * <p>
 *      synchronized等价示例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/9 21:46
 */
public class SynFeatureExample {

    /** 定义一个64位长度的普通变量 */
    long v1 = 0L;

    /**
     * 使用同步锁对v1变量进行写操作
     * @param l
     */
    public synchronized void set(long l) {
        v1 = l;
    }


    /**
     *  通过同步读和同步写方法对v1进行+1操作
     */
    public void getAndIncrement() {
        long temp = get();
        // v1加一
        temp += 1L;
        set(temp);
    }

    /**
     * 使用同步锁对v1进行读操作
     * @return
     */
    public synchronized long get() {
        return v1;
    }

}
