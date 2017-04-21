package com.saiu.algorithms.interview.other.officeVisitors;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Karnov @date 26.02.17.
 * artem.karnov@t-systems.com
 */

/**
 * Algorithm for finding most visited day of stamp array.
 * We store data in array of TimeStamps and looking in it for result
 */
public class OfficeVisitors {
    private ArrayList<TimeStamp> stamps;
    private Map<Date, Integer> result = new HashMap<>();

    private void dayToMapConverter() {
        for (TimeStamp currentTimeStamp : stamps) {
            plusRecord(customDayParser(currentTimeStamp.getArrivalTime()));
            plusRecord(customDayParser(currentTimeStamp.getDepatureTime()));
        }
    }

    /**
     * Each date considered as day-mark data.
     * 12:43:34 01.02.2017 --> 00:00:00 01.02.2017
     * 23:59:29 01.02.2017 --> 00:00:00 01.02.2017
     * 00:00:01 02.02.2017 --> 00:00:00 02.02.2017
     * This method using for day to day-mark mapping
     *
     * @param date date for mapping
     * @return day-mark
     */
    private Date customDayParser(Date date) {
        Calendar newDate = new GregorianCalendar();
        newDate.setTime(date);
        newDate.set(Calendar.HOUR_OF_DAY, 0);
        newDate.set(Calendar.MINUTE, 0);
        newDate.set(Calendar.SECOND, 0);
        newDate.set(Calendar.MILLISECOND, 0);
        return newDate.getTime();
    }

    /**
     * Addition day-mark to map for storing.
     *
     * @param date date for adding
     */
    private void plusRecord(Date date) {
        if (result.containsKey(date)) {
            result.replace(date, result.get(date) + 1);
        } else
            result.put(date, 0);
    }

    /**
     * Getting most visited day
     *
     * @return most visited day
     */
    public Date getMostVisitedDay() {
        dayToMapConverter();
        Map.Entry<Date, Integer> maxEntry = null;
        for (Map.Entry<Date, Integer> entry : result.entrySet()) {
            if (maxEntry == null)
                maxEntry = entry;
            if (entry.getValue() > maxEntry.getValue())
                maxEntry = entry;
        }
        return maxEntry.getKey();
    }

    /**
     * TimeStamp array initialization
     *
     * @param stamps data for initialization
     */
    public void setTimeStamps(ArrayList<TimeStamp> stamps) {
        this.stamps = stamps;
    }
}
