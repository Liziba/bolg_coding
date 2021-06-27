package com.lizba.currency.p3;

import com.lizba.currency.p2.SleepUtil;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/16 22:04
 */
public class Profiler {

    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };


    public static final void begin() {
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static final Long end() {
        return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
    }


    public static void main(String[] args) {
        Profiler.begin();
        SleepUtil.sleepSecond(1);
        System.out.println("Cost: " + Profiler.end());
    }
}
