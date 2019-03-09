package ru.siksmfp.basic.algorithm.sort.algorithm;

import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {

    private SortAlgorithm<Integer> insertionSort;

    @Before
    public void setUp() {
        insertionSort = new InsertionSort<>();
    }

    @Test
    public void ascOrderTest() {
        SortTest.ascOrderTest(insertionSort);
    }

    @Test
    public void descOrderTest() {
        SortTest.descOrderTest(insertionSort);
    }

    @Test
    public void mixArrayOrderTest() {
        SortTest.mixArrayOrderTest(insertionSort);
    }

    @Test
    public void emptyArrayTest() {
        SortTest.emptyArrayTest(insertionSort);
    }

    @Test
    public void oneElementArrayTest() {
        SortTest.oneElementArrayTest(insertionSort);
    }

    @Test
    public void performanceTest1() {
        SortTest.performanceTest1(insertionSort);
    }

    @Test
    public void performanceTest2() {
        SortTest.performanceTest2(insertionSort);
    }
}