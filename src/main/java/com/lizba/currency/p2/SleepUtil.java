package com.lizba.currency.p2;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *      睡眠指定时间工工具类
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/14 13:27
 */
public class SleepUtil {

    public static final void sleepSecond(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
