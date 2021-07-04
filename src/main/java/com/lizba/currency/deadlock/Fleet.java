package com.lizba.currency.deadlock;

import java.util.Set;

/**
 * <p>
 *      车队类 -> 调度管理出租车
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/1 14:06
 */
public class Fleet {

    /** 车队中所有出租车 */
    private final Set<Taxi> taxis;
    /** 车队中目前空闲的出租车 */
    private final Set<Taxi> available;

    public Fleet(Set<Taxi> taxis) {
        this.taxis = this.available = taxis;
    }


    /**
     * 出租车到达目的地后调用该方法，向车队发出当前出租车空闲信息
     *
     * @param taxi
     */
    public synchronized void free(Taxi taxi) {
        available.add(taxi);
    }


    /**
     * 获取所有出租车在不同时刻的地址快照
     * @return
     */
    public synchronized Image getImage() {
        Image image = new Image();
        for (Taxi taxi : taxis) {
            image.drawMarker(taxi);
        }
        return image;
    }
    
}
