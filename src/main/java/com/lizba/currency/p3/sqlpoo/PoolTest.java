package com.lizba.currency.p3.sqlpoo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 连接池测试
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/17 17:51
 */
public class PoolTest {

    /** 初始化线程池 */
    private static ConnectionPool pool = new ConnectionPool(10);
    /** 保证所有线程都一起执行 */
    private static CountDownLatch start = new CountDownLatch(1);
    /** 保证main线程执行在所有线程执行完之后再往后执行 */
    private static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        // 定义获取连接的线程数量
        int threadSize = 40;
        // 定义每个线程获取连接的次数
        int count = 50;
        end = new CountDownLatch(threadSize);
        AtomicInteger getConnectionCount = new AtomicInteger();
        AtomicInteger notGetConnectionCount = new AtomicInteger();
        for (int i = 0; i < threadSize; i++) {
            Thread t = new Thread(new Runner(count, getConnectionCount, notGetConnectionCount), "thread1");
            t.start();
        }
        start.countDown();
        end.await();
        System.out.println("执行次数" + (threadSize * count));
        System.out.println("获取连接次数" + getConnectionCount);
        System.out.println("未获取连接次数" + notGetConnectionCount);


    }

    static class Runner implements Runnable {

        private int count;
        private AtomicInteger getConnectionCount;
        private AtomicInteger notGetConnectionCount;

        public Runner(int count, AtomicInteger getConnectionCount, AtomicInteger notGetConnectionCount) {
            this.count = count;
            this.getConnectionCount = getConnectionCount;
            this.notGetConnectionCount = notGetConnectionCount;
        }

        @Override
        public void run() {
            try {
                // 等待知道主线程执行完start.countDown();
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 循环获取连接
            while (count > 0) {
                try {
                    Connection connection = pool.connection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            // 释放连接
                            pool.releaseConnection(connection);
                            // 记录获取的数量
                            getConnectionCount.incrementAndGet();
                        }
                    } else {
                        // 记录未获取到的数量
                        notGetConnectionCount.incrementAndGet();
                    }
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }

}
