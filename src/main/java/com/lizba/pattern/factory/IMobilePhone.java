package com.lizba.pattern.factory;

/**
 * <p>
 *      移动手机接口
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 21:06
 */
public interface IMobilePhone {

    /**
     * 发消息
     */
    void sendShortMessage();

    /**
     * 打电话
     */
    void call();

}
