package com.lizba.currency.p2;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/13 23:03
 */
public class MultiThread {

    public static void main(String[] args) {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 获取线程和线程堆栈信息；
        // boolean lockedMonitors        false  不需要获取同步的monitor信息
        // boolean lockedSynchronizers   false  不需要获取同步的synchronizer信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 打印线程ID和线程name
        Arrays.stream(threadInfos).forEach(threadInfo -> {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        });
    }

}
