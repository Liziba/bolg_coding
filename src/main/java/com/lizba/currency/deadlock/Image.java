package com.lizba.currency.deadlock;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  获取所有出租车在某一时刻的位置快照
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/1 14:14
 */
public class Image {

    Map<String, Coordinate> locationSnapshot = new HashMap<>();

    public void drawMarker(Taxi taxi) {
        locationSnapshot.put(taxi.getId(), taxi.getLocation());
    }

    public void drawMarker(TaxiOptimize taxi) {
        locationSnapshot.put(taxi.getId(), taxi.getLocation());
    }

}
