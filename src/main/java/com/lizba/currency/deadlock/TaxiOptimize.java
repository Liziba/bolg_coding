package com.lizba.currency.deadlock;

import java.util.Objects;

/**
 * <p>
 *      出租车类优化
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/1 16:01
 */
public class TaxiOptimize {

    /** 出租车唯一标志 */
    private String id;
    /** 当前坐标 */
    private Coordinate location;
    /** 目的地坐标 */
    private Coordinate destination;
    /** 所属车队 */
    private final FleetOptimize fleet;

    public TaxiOptimize(FleetOptimize fleet) {
        this.fleet = fleet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取当前地址信息
     * @return
     */
    public synchronized Coordinate getLocation() {
        return location;
    }

    /**
     * 更新当前地址信息
     * 如果当前地址与目的地地址一致，则表名到达目的地需要通知车队，当前出租车空闲可用前往下一个目的地
     *
     * @param location
     */
    public void setLocation(Coordinate location) {
        this.location = location;
        boolean release = false;
        synchronized (this) {
            if (location.equals(destination)) {
                release = true;
            }
        }
        if (release) {
            fleet.free(this);
        }
    }

    public Coordinate getDestination() {
        return destination;
    }

    /**
     * 设置目的地
     *
     * @param destination
     */
    public synchronized void setDestination(Coordinate destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxiOptimize taxi = (TaxiOptimize) o;
        return Objects.equals(location, taxi.location) &&
                Objects.equals(destination, taxi.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, destination);
    }

}
