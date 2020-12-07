package ru.siksmfp.basic.algorithm.sort.algorithm;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    private SortAlgorithm<Integer> bubbleSort;

    @Before
    public void setUp() {
        bubbleSort = new BubbleSort<>();
    }

    @Test
    public void ascOrderTest() {
        SortTest.ascOrderTest(bubbleSort);
    }

    @Test
    public void descOrderTest() {
        SortTest.descOrderTest(bubbleSort);
    }

    @Test
    public void mixArrayOrderTest() {
        SortTest.mixArrayOrderTest(bubbleSort);
    }

    @Test
    public void emptyArrayTest() {
        SortTest.emptyArrayTest(bubbleSort);
    }

    @Test
    public void oneElementArrayTest() {
        SortTest.oneElementArrayTest(bubbleSort);
    }

    @Test
    public void allTheSameAskTest() {
        SortTest.allSameAskElements(bubbleSort);
    }

    @Test
    public void allTheSameDescTest() {
        SortTest.allSameAskElements(bubbleSort);
    }

    @Test
    public void performanceTest1() {
        SortTest.performanceTest1(bubbleSort);
    }

    @Test
    public void performanceTest2() {
        SortTest.performanceTest2(bubbleSort);
    }
}