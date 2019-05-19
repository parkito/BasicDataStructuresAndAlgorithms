package ru.siksmfp.basic.algorithm.sort.algorithm;

import org.junit.BeforeClass;
import org.junit.Test;

public class MergeSortTest {

    private static SortAlgorithm<Integer> mergeSort;

    @BeforeClass
    public static void setUp() {
        mergeSort = new MergeSort<>();
    }

    @Test
    public void ascOrderTest() {
        SortTest.ascOrderTest(mergeSort);
    }

    @Test
    public void descOrderTest() {
        SortTest.descOrderTest(mergeSort);
    }

    @Test
    public void mixArrayOrderTest() {
        SortTest.mixArrayOrderTest(mergeSort);
    }

    @Test
    public void emptyArrayTest() {
        SortTest.emptyArrayTest(mergeSort);
    }

    @Test
    public void oneElementArrayTest() {
        SortTest.oneElementArrayTest(mergeSort);
    }

    @Test
    public void allTheSameAskTest() {
        SortTest.allSameAskElements(mergeSort);
    }

    @Test
    public void allTheSameDescTest() {
        SortTest.allSameAskElements(mergeSort);
    }

    @Test
    public void performanceTest1() {
        SortTest.performanceTest1(mergeSort);
    }

    @Test
    public void performanceTest2() {
        SortTest.performanceTest2(mergeSort);
    }

    @Test
    public void performanceTest3() {
        SortTest.performanceTest3(mergeSort);
    }
}