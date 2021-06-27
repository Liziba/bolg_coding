package com.lizba.currency.p6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *      使用ReentrantReadWriteLock实现一个简单的线程安全基于map的缓存设计
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/22 22:11
 */
public class CacheDemo {

    /** 存储数据容器 */
    private static Map<String, Object> cache = new HashMap<>();
    /** 读写锁ReentrantReadWriteLock */
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /** 读锁 */
    static Lock readLock = lock.readLock();
    /** 写锁 */
    static Lock writeLock = lock.writeLock();

    /**
     * 获取数据，使用读锁加锁
     * @param key
     * @return
     */
    public static Object get(String key) {
        readLock.lock();
        try {
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 设置key&value，使用写锁，禁止其他线程的读取和写入
     * @param key
     * @param value
     * @return
     */
    public static void put(String key, Object value) {
        writeLock.lock();
        try {
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 情况缓存
     */
    public static void flush() {
        writeLock.lock();
        try {
            cache.clear();
        } finally {
            writeLock.unlock();
        }
    }


}
