package com.lizba.currency.p3.threadpool;

import com.lizba.currency.p2.SleepUtil;

/**
 * <p>
 *      线程池测试
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/17 23:19
 */
public class PoolTest {

    public static void main(String[] args) {

        DefaultThreadPool pool = new DefaultThreadPool();
        // 提交10个任务
        int size = 10;
        for (int i = 0; i < size; i++) {
            Thread job = new Thread(new Runnable() {
                @Override
                public void run() {
                    SleepUtil.sleepSecond(1);
                    System.out.println(Thread.currentThread().getName() + " 执行Job任务");
                }
            });

            pool.execute(job);
        }


    }

}
