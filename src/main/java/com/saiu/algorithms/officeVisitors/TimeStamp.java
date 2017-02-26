package com.saiu.algorithms.officeVisitors;

import java.util.Date;

/**
 * @author Artem Karnov @date 26.02.17.
 *         artem.karnov@t-systems.com
 */

public class TimeStamp {
    private int employerId;
    private Date enterTime;
    private Date exitTime;

    public TimeStamp(int employerId, Date enterTime, Date exitTime) {
        this.employerId = employerId;
        this.enterTime = enterTime;
        this.exitTime = exitTime;
    }

    public int getEmployerId() {
        return employerId;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public Date getExitTime() {
        return exitTime;
    }
}
