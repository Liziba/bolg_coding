package com.lizba.currency.p3.sqlpoo;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * <p>
 *  数据库连接池
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/17 21:13
 */
public class ConnectionPool {

    /** 默认连接池大小 */
    private static final int DEFAULT_SIZE = 10;
    /** 连接池存储容器 */
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        // 参数不正确默认初始化10
        initialSize = initialSize <= 0 ? DEFAULT_SIZE : initialSize;
        for (int i = 0; i < initialSize; i++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    /**
     * 释放连接，重回连接池，并且通知等待中的消费者
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                // 通知消费者
                pool.notifyAll();
            }
        }
    }


    /**
     * 直接获取连接，不知道超时时间，则会一直等待
     *
     * @return
     * @throws InterruptedException
     */
    public Connection connection() throws InterruptedException {
       return connection(0);
    }

    /**
     * 指定获取连接时间
     *
     * @param mills
     * @return
     * @throws InterruptedException
     */
    public Connection connection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(mills);
                    remaining = future - System.currentTimeMillis();
                }
                return pool.isEmpty() ? null : pool.removeFirst();
            }
        }
    }
}
