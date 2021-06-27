package com.lizba.currency.p6;


import java.lang.reflect.Array;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/27 11:46
 */
public class Heap<T> {

    private int N;
    private T[] items;

    public Heap(Class<T> componentType, int capacity) {
        this.items = (T[])Array.newInstance(componentType, capacity);
    }
}
