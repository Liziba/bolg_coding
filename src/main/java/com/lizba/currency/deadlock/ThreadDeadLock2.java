package com.lizba.currency.deadlock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>
 *      线程饥饿锁
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/1 16:51
 */
public class ThreadDeadLock2 {


    private ExecutorService pool = Executors.newSingleThreadExecutor();

    public class Render implements Callable {

        @Override
        public Object call() throws Exception {
            pool.submit(new Task());
            return null;
        }
    }

    public class Task implements Runnable {

        @Override
        public void run() {
            
        }
    }


}
