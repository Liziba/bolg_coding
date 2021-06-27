package com.lizba.currency.p1;

/**
 * <p>
 *      同步示例
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/8 21:44
 */
public class SynReorderExample {


    // 定义变量a
    int a = 0;
    // flag变量是个标记，用来标志变量a是否被写入
    boolean flag = false;

    public synchronized void writer() {     // 获取锁
        a = 1;
        flag = true;
    }                                       // 释放锁

    public synchronized void reader() {     // 获取锁
        if (flag) {
            int i = a * a;
            System.out.println("i:" + i);
        }
    }                                       // 释放锁


    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

        final SynReorderExample re = new SynReorderExample();

        new Thread() {
            public void run() {
                re.writer();
            }
        }.start();

        new Thread() {
            public void run() {
                re.reader();
            }
        }.start();
    }

}
