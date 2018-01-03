package test.java.saiu.algorithms.general.sorts;

import org.junit.Assert;
import org.junit.Test;
import ru.siksmfp.basic.algorithm.sort.Sort;

/**
 * @author Artem Karnov @date 21.04.2017.
 * artem.karnov@t-systems.com
 */

public class SortTest {

    @Test
    public void bubbleSortTestOne() {
        long array[] = {3, 2, 1, 4, 5};
        long expected[] = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, new Sort(array).bubbleSort());
    }


    @Test
    public void bubbleSortTestTwo() {
        long array[] = {3, 2, 1, 0, 10000, 4, 5};
        long expected[] = {0, 1, 2, 3, 4, 5, 10000};
        Assert.assertArrayEquals(expected, new Sort(array).bubbleSort());
    }

    @Test
    public void inertSortTestOne() {
        long array[] = {3, 2, 1, 4, 5};
        long expected[] = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, new Sort(array).insertSort());
    }


    @Test
    public void insertSortTestTwo() {
        long array[] = {3, 2, 1, 0, 10000, 4, 5};
        long expected[] = {0, 1, 2, 3, 4, 5, 10000};
        Assert.assertArrayEquals(expected, new Sort(array).insertSort());
    }

    @Test
    public void insertSortTestthree() {
        long array[] = {};
        long expected[] = {};
        Assert.assertArrayEquals(expected, new Sort(array).insertSort());
    }
}