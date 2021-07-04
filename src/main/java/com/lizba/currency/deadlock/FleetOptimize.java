package com.lizba.currency.deadlock;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *      出租车车队类优化
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/1 16:03
 */
public class FleetOptimize {


    /** 车队中所有出租车 */
    private final Set<TaxiOptimize> taxis;
    /** 车队中目前空闲的出租车 */
    private final Set<TaxiOptimize> available;

    public FleetOptimize(Set<TaxiOptimize> taxis) {
        this.taxis = this.available = taxis;
    }


    /**
     * 出租车到达目的地后调用该方法，向车队发出当前出租车空闲信息
     *
     * @param taxi
     */
    public synchronized void free(TaxiOptimize taxi) {
        available.add(taxi);
    }


    /**
     * 获取所有出租车在不同时刻的地址快照
     * @return
     */
    public Image getImage() {
        Set<TaxiOptimize> copy ;
        synchronized (this) {
            copy = new HashSet<TaxiOptimize>(taxis);
        }
        Image image = new Image();
        for (TaxiOptimize taxi : copy) {
            image.drawMarker(taxi);
        }
        return image;
    }

}
