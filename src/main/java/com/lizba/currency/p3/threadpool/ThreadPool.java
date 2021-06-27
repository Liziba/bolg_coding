package com.lizba.currency.p3.threadpool;

/**
 * <p>
 *      线程池接口
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/17 22:28
 */
public interface ThreadPool<Job extends Runnable> {

    /**
     * 执行一个Job，这个Job需要实现Runnable
     * @param job
     */
    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     * @param num
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     * @param num
     */
    void removeWorkers(int num);

    /**
     * 得到正在等待执行的任务数量
     * @return
     */
    int getJobSize();
}
