package ru.siksmfp.basic.algorithm.sort.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.siksmfp.basic.structure.array.DynamicArray;

import static ru.siksmfp.basic.algorithm.sort.SortDirection.ASC;
import static ru.siksmfp.basic.algorithm.sort.SortDirection.DESC;

public class BubbleSortTest {

    public static final int TEN_THOUSANDS = 10_000;
    public static final int HUNDRED_THOUSANDS = 100_000;
    public static final int MILLION = 1_000_000;
    public static final int BILLION = 1_000_000_000;

    private SortAlgorithm<Integer> bubbleSort;

    @Before
    public void setUp() {
        bubbleSort = new BubbleSort<>();
    }

    @Test
    public void ascOrderTest() {
        DynamicArray<Integer> array = new DynamicArray<>(5, 4, 3, 2, 1);

        bubbleSort.sort(array, ASC);

        Assert.assertEquals(1, array.get(0).intValue());
        Assert.assertEquals(2, array.get(1).intValue());
        Assert.assertEquals(3, array.get(2).intValue());
        Assert.assertEquals(4, array.get(3).intValue());
        Assert.assertEquals(5, array.get(4).intValue());
    }

    @Test
    public void descOrderTest() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3, 4, 5);

        bubbleSort.sort(array, DESC);

        Assert.assertEquals(5, array.get(0).intValue());
        Assert.assertEquals(4, array.get(1).intValue());
        Assert.assertEquals(3, array.get(2).intValue());
        Assert.assertEquals(2, array.get(3).intValue());
        Assert.assertEquals(1, array.get(4).intValue());
    }

    @Test
    public void emptyArrayTest() {
        DynamicArray<Integer> array = new DynamicArray<>();

        bubbleSort.sort(array, DESC);

        Assert.assertEquals(0, array.size());
    }

    @Test
    public void oneElementArrayTest() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(1);

        bubbleSort.sort(array, DESC);

        Assert.assertEquals(1, array.size());
        Assert.assertEquals(1, array.get(0).intValue());
    }

    @Test
    public void performanceTest1() {
        DynamicArray<Integer> array = new DynamicArray<>(TEN_THOUSANDS + 1);
        for (int i = TEN_THOUSANDS; i >= 0; i--) {
            array.add(i, i);
        }

        bubbleSort.sort(array, DESC);

        for (int i = 0; i < TEN_THOUSANDS; i++) {
            Assert.assertEquals(i, TEN_THOUSANDS - array.get(i));
        }
    }

    @Test
    public void performanceTest2() {
        DynamicArray<Integer> array = new DynamicArray<>(HUNDRED_THOUSANDS + 1);
        for (int i = HUNDRED_THOUSANDS; i >= 0; i--) {
            array.add(i, i);
        }

        bubbleSort.sort(array, DESC);

        for (int i = 0; i < HUNDRED_THOUSANDS; i++) {
            Assert.assertEquals(i, HUNDRED_THOUSANDS - array.get(i));
        }
    }

    @Test
    public void performanceTest3() {
        DynamicArray<Integer> array = new DynamicArray<>(MILLION + 1);
        for (int i = MILLION; i >= 0; i--) {
            array.add(i, i);
        }

        bubbleSort.sort(array, DESC);

        for (int i = 0; i < MILLION; i++) {
            Assert.assertEquals(i, MILLION - array.get(i));
        }
    }

    @Test
    public void performanceTest4() {
        DynamicArray<Integer> array = new DynamicArray<>(BILLION + 1);
        for (int i = BILLION; i >= 0; i--) {
            array.add(i, i);
        }

        bubbleSort.sort(array, DESC);

        for (int i = 0; i < BILLION; i++) {
            Assert.assertEquals(i, BILLION - array.get(i));
        }
    }

}