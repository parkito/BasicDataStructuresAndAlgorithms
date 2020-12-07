package ru.siksmfp.basic.algorithm.sort.algorithm;

import org.junit.Before;
import org.junit.Test;

public class SelectionSortTest {

    private SortAlgorithm<Integer> selectionSort;

    @Before
    public void setUp() {
        selectionSort = new SelectionSort<>();
    }

    @Test
    public void ascOrderTest() {
        SortTest.ascOrderTest(selectionSort);
    }

    @Test
    public void descOrderTest() {
        SortTest.descOrderTest(selectionSort);
    }

    @Test
    public void mixArrayOrderTest() {
        SortTest.mixArrayOrderTest(selectionSort);
    }

    @Test
    public void emptyArrayTest() {
        SortTest.emptyArrayTest(selectionSort);
    }

    @Test
    public void oneElementArrayTest() {
        SortTest.oneElementArrayTest(selectionSort);
    }

    @Test
    public void allTheSameAskTest() {
        SortTest.allSameAskElements(selectionSort);
    }

    @Test
    public void allTheSameDescTest() {
        SortTest.allSameAskElements(selectionSort);
    }

    @Test
    public void performanceTest1() {
        SortTest.performanceTest1(selectionSort);
    }

    @Test
    public void performanceTest2() {
        SortTest.performanceTest2(selectionSort);
    }
}
