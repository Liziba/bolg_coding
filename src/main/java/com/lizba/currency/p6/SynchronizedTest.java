package com.lizba.currency.p6;

/**
 * <p>
 *      synchronized锁测试
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/21 21:45
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        int sum = cal(0);
        System.out.println(sum);
    }

    /**
     * 简单递归重入，递归十次
     * @param i
     * @return
     */
    private static synchronized int cal(int i) {
        if (i < 10) {
            return cal(++i);
        }
        return i;
    }

}
