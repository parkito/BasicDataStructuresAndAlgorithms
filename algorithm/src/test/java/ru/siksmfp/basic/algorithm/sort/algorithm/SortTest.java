package ru.siksmfp.basic.algorithm.sort.algorithm;

import org.junit.Assert;
import ru.siksmfp.basic.structure.array.DynamicArray;

import static ru.siksmfp.basic.algorithm.sort.SortDirection.ASC;
import static ru.siksmfp.basic.algorithm.sort.SortDirection.DESC;

public class SortTest {

    private static final int TEN_THOUSANDS = 10_000;
    private static final int HUNDRED_THOUSANDS = 100_000;
    private static final int MILLION = 1_000_000;
    private static final int BILLION = 1_000_000_000;

    public static void ascOrderTest(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>(5, 4, 3, 2, 1);

        algorithm.sort(array, ASC);

        Assert.assertEquals(1, array.get(0).intValue());
        Assert.assertEquals(2, array.get(1).intValue());
        Assert.assertEquals(3, array.get(2).intValue());
        Assert.assertEquals(4, array.get(3).intValue());
        Assert.assertEquals(5, array.get(4).intValue());
    }

    public static void descOrderTest(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3, 4, 5);

        algorithm.sort(array, DESC);

        Assert.assertEquals(5, array.get(0).intValue());
        Assert.assertEquals(4, array.get(1).intValue());
        Assert.assertEquals(3, array.get(2).intValue());
        Assert.assertEquals(2, array.get(3).intValue());
        Assert.assertEquals(1, array.get(4).intValue());
    }

    public static void mixArrayOrderTest(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>(7, 2, 4, 9, 11, 23);

        algorithm.sort(array, DESC);

        Assert.assertEquals(23, array.get(0).intValue());
        Assert.assertEquals(11, array.get(1).intValue());
        Assert.assertEquals(9, array.get(2).intValue());
        Assert.assertEquals(7, array.get(3).intValue());
        Assert.assertEquals(4, array.get(4).intValue());
        Assert.assertEquals(2, array.get(5).intValue());
    }

    public static void emptyArrayTest(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>();

        algorithm.sort(array, DESC);

        Assert.assertEquals(0, array.size());
    }

    public static void oneElementArrayTest(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(1);

        algorithm.sort(array, DESC);

        Assert.assertEquals(1, array.size());
        Assert.assertEquals(1, array.get(0).intValue());
    }

    public static void performanceTest1(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>(TEN_THOUSANDS + 1);
        for (int i = TEN_THOUSANDS; i >= 0; i--) {
            array.add(i, i);
        }

        algorithm.sort(array, DESC);

        for (int i = 0; i < TEN_THOUSANDS; i++) {
            Assert.assertEquals(i, TEN_THOUSANDS - array.get(i));
        }
    }

    public static void performanceTest2(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>(HUNDRED_THOUSANDS + 1);
        for (int i = HUNDRED_THOUSANDS; i >= 0; i--) {
            array.add(i, i);
        }

        algorithm.sort(array, DESC);

        for (int i = 0; i < HUNDRED_THOUSANDS; i++) {
            Assert.assertEquals(i, HUNDRED_THOUSANDS - array.get(i));
        }
    }

    public static void performanceTest3(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>(MILLION + 1);
        for (int i = MILLION; i >= 0; i--) {
            array.add(i, i);
        }

        algorithm.sort(array, DESC);

        for (int i = 0; i < MILLION; i++) {
            Assert.assertEquals(i, MILLION - array.get(i));
        }
    }

    public static void performanceTest4(SortAlgorithm<Integer> algorithm) {
        DynamicArray<Integer> array = new DynamicArray<>(BILLION + 1);
        for (int i = BILLION; i >= 0; i--) {
            array.add(i, i);
        }

        algorithm.sort(array, DESC);

        for (int i = 0; i < BILLION; i++) {
            Assert.assertEquals(i, BILLION - array.get(i));
        }
    }
}
