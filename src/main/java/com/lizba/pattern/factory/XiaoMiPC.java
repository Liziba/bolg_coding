package com.lizba.pattern.factory;

/**
 * <p>
 *     小米电脑
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 22:12
 */
public class XiaoMiPC implements ILaptop {

    @Override
    public void coding() {
        System.out.println("coding on MacBook...");
    }

    @Override
    public void playGame() {
        System.out.println("play game on MacBook...");
    }

}
