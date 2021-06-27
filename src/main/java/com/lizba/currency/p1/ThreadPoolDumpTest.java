package com.lizba.currency.p1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *      线程池Dump测试
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/4 23:26
 */
public class ThreadPoolDumpTest {

    public static void main(String[] args) {
        // 创建固定大小的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        // 初始化线程池中的线程
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(getThread(i));
        }
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("测试！");
        }

    }

    /**
     * 创建线程
     * @param i
     * @return
     */
    private static Runnable getThread(final int i) {

        return new Runnable() {
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };
    }

}
