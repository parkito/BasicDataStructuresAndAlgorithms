package com.saiu.algorithms.officeVisitors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Artem Karnov @date 26.02.17.
 *         artem.karnov@t-systems.com
 */

public class OfficeVisitors {
    private Collection stamps;

    public OfficeVisitors() {
        stamps = new ArrayList<TimeStamp>();
    }

    public void TimeStampGenerator() {
        //Day two id has most of all visitors
        int workerOne = 1;
        int workerTwo = 2;
        int workerThree = 2;
        int workerFour = 3;
        int workerFive = 4;
        //firstDay
        long dayOneFirst = 1485960781;
        long dayOneSecond = 1485960841;
        long dayOneThird = 1485960901;
        long dayOneFourth = 1485960961;
        long dayOneFiveth = 1485964521;
        long dayOneSixth = 1485964561;
        //secondDay
        long dayTwoFirst = 1488383761;
        long dayTwoSecond = 1488383881;
        //thirdDay
        //the oftenest
        long dayThreeFirst = 1493654281;
        long dayThreeSecond = 1493654341;
        long dayThreeThird = 1493654401;
        long dayThreeFourth = 1493654461;
        long dayThreeFiveth = 1493654521;
        long dayThreeSixth = 1493654701;

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
}
