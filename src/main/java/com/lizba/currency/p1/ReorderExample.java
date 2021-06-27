package com.lizba.currency.p1;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/7 23:01
 */
public class ReorderExample {

    // 定义变量a
    int a = 0;
    // flag变量是个标记，用来标志变量a是否被写入
    boolean flag = false;

    public void writer() {
        a = 1;                           // 1
        flag = true;                     // 2
    }

    public void reader() {
        if (flag) {                      // 3
            int i = a * a;               // 4
            System.out.println("i:" + i);
        }
    }


    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

        final ReorderExample re = new ReorderExample();

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
