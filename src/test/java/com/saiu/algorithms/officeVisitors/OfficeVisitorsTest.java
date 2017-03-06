package com.saiu.algorithms.officeVisitors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Artem Karnov @date 01.03.2017.
 *         artem.karnov@t-systems.com
 */

public class OfficeVisitorsTest {
    private ArrayList<TimeStamp> stamps;
    private OfficeVisitors officeVisitors;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Before
    public void setUp() {
        stamps = new ArrayList<>();
        officeVisitors = new OfficeVisitors();
    }

    public void timeStampGenerator() {
        //Day two id has most of all visitors
        int workerOne = 1;
        int workerTwo = 2;
        int workerThree = 2;
        int workerFour = 3;
        int workerFive = 4;
        //firstDay
        long dayOneFirst = 1485960781000L;
        long dayOneSecond = 1485960841000L;
        long dayOneThird = 1485960901000L;
        long dayOneFourth = 1485960961000L;
        long dayOneFiveth = 1485964521000L;
        long dayOneSixth = 1485964561000L;
        //secondDay
        long dayTwoFirst = 1488383761000L;
        long dayTwoSecond = 1488383881000L;
        //thirdDay
        //the oftenest
        long dayThreeFirst = 1493654281000L;
        long dayThreeSecond = 1493654341000L;
        long dayThreeThird = 1493654401000L;
        long dayThreeFourth = 1493654461000L;
        long dayThreeFiveth = 1493654521000L;
        long dayThreeSixth = 1493654701000L;

        stamps.add(new TimeStamp(workerOne, new Date(dayOneFirst), new Date(dayOneSecond)));
        stamps.add(new TimeStamp(workerTwo, new Date(dayOneSecond), new Date(dayOneThird)));
        stamps.add(new TimeStamp(workerThree, new Date(dayOneFourth), new Date(dayOneFiveth)));
        stamps.add(new TimeStamp(workerFour, new Date(dayOneSixth), new Date(dayOneSixth)));

        stamps.add(new TimeStamp(workerOne, new Date(dayTwoFirst), new Date(dayTwoSecond)));

        stamps.add(new TimeStamp(workerOne, new Date(dayThreeFirst), new Date(dayThreeSecond)));
        stamps.add(new TimeStamp(workerTwo, new Date(dayThreeFirst), new Date(dayThreeSecond)));
        stamps.add(new TimeStamp(workerFour, new Date(dayThreeThird), new Date(dayThreeFourth)));
        stamps.add(new TimeStamp(workerThree, new Date(dayThreeThird), new Date(dayThreeFourth)));
        stamps.add(new TimeStamp(workerFive, new Date(dayThreeFiveth), new Date(dayThreeSixth)));
    }

    @Test
    public void getMostVisitedDay() throws Exception {
        timeStampGenerator();
        officeVisitors.setTimeStamps(stamps);
        Assert.assertEquals(officeVisitors.getMostVisitedDay(), new Date(1493586000000L));
    }

}