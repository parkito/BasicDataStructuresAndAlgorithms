package com.saiu.algorithms.officeVisitors;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Karnov @date 26.02.17.
 *         artem.karnov@t-systems.com
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

    private Date customDayParser(Date date) {
        Calendar newDate = new GregorianCalendar();
        Calendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        newDate.set(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_WEEK));
        return newDate.getTime();
    }

    private void plusRecord(Date date) {
        if (result.containsKey(date)) {
            result.replace(date, result.get(date) + 1);
        } else result.put(date, 0);
    }

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

    public void setTimeStamps(ArrayList<TimeStamp> stamps) {
        this.stamps = stamps;
    }
}
