package com.lizba.pattern.factory;

/**
 * <p>
 *      华为电脑
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/28 22:11
 */
public class MagicBook implements ILaptop {

    @Override
    public void coding() {
        System.out.println("coding on MacBook...");
    }

    @Override
    public void playGame() {
        System.out.println("play game on MacBook...");
    }

}
