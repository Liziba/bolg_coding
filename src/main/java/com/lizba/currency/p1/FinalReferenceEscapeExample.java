package com.lizba.currency.p1;

/**
 * <p>
 *   final引用逸出demo
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/11 22:33
 */
public class FinalReferenceEscapeExample {

    final int i;
    static FinalReferenceEscapeExample obj;

    public FinalReferenceEscapeExample() {
        i = 1;                                            // 1、写final域
        obj = this;          // 2、this引用在此处"逸出"
    }

    public static void writer() {
        new FinalReferenceEscapeExample();
    }

    public static void reader() {
        if (obj != null) {                 // 3
            int temp = obj.i;              // 4
        }
    }
}
