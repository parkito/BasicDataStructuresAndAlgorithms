package com.saiu.algorithms.officeVisitors;

import java.util.Date;

/**
 * @author Artem Karnov @date 26.02.17.
 *         artem.karnov@t-systems.com
 */

public class TimeStamp {
    private int employerId;
    private Date arrivalTime;
    private Date depatureTime;

    public TimeStamp(int employerId, Date enterTime, Date exitTime) {
        this.employerId = employerId;
        this.arrivalTime = enterTime;
        this.depatureTime = exitTime;
    }

    public int getEmployerId() {
        return employerId;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Date getDepatureTime() {
        return depatureTime;
    }
}
