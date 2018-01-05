package test.java.saiu.algorithms.general.sorts;

import org.junit.Assert;
import org.junit.Test;
import ru.siksmfp.basic.algorithm.sort.Sort;
import ru.siksmfp.basic.algorithm.sort.SortDirection;
import ru.siksmfp.basic.structure.array.dynamic.Array;

/**
 * @author Artem Karnov @date 21.04.2017.
 * artem.karnov@t-systems.com
 */

public class SortTest {

    @Test
    public void bubbleSortTestOne() {
        Array array = new Array(3, 2, 1, 4, 5);
        Array expected = new Array(1, 2, 3, 4, 5);
        Sort.bubbleSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void bubbleSortTestTwo() {
        Array array = new Array(3, 2, 1, 0, 10000, 4, 5);
        Array expected = new Array(0, 1, 2, 3, 4, 5, 10000);
        Sort.bubbleSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void bubbleSortTestThree() {
        Array array = new Array(3, 2, 1, 0, 10000, 4, 5);
        Array expected = new Array(10000, 5, 4, 3, 2, 1, 0);
        Sort.bubbleSort(array, SortDirection.DESC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void bubbleSortTestFour() {
        Array array = new Array();
        Array expected = new Array();
        Sort.bubbleSort(array, SortDirection.DESC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void selectSortTestOne() {
        Array array = new Array(3, 2, 1, 4, 5);
        Array expected = new Array(1, 2, 3, 4, 5);
        Sort.selectionSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void selectSortTestTwo() {
        Array array = new Array(3, 2, 1, 4, 5);
        Array expected = new Array(5, 4, 3, 2, 1);
        Sort.selectionSort(array, SortDirection.DESC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void selectSortTestThree() {
        Array array = new Array(3, 2, 1, 0, 10000, 4, 5);
        Array expected = new Array(0, 1, 2, 3, 4, 5, 10000);
        Sort.selectionSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void selectSortTestFour() {
        Array array = new Array();
        Array expected = new Array();
        Sort.selectionSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void insertSortTestOne() {
        Array array = new Array(3, 2, 1, 4, 5);
        Array expected = new Array(1, 2, 3, 4, 5);
        Sort.insertionSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void insertSortTesTwo() {
        Array array = new Array(3, 2, 1, 4, 5);
        Array expected = new Array(5, 4, 3, 2, 1);
        Sort.insertionSort(array, SortDirection.DESC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void insertSortTestThree() {
        Array array = new Array(3, 2, 1, 0, 10000, 4, 5);
        Array expected = new Array(0, 1, 2, 3, 4, 5, 10000);
        Sort.insertionSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void insertSortTestFour() {
        Array array = new Array();
        Array expected = new Array();
        Sort.insertionSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void insertClassicSortTestOne() {
        Array array = new Array(3, 2, 1, 4, 5);
        Array expected = new Array(1, 2, 3, 4, 5);
        Sort.classicInsertionSort(array, SortDirection.ASC);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void insertClssicSortTesTwo() {
        Array array = new Array(3, 2, 1, 4, 5);
        Array expected = new Array(5, 4, 3, 2, 1);
        Sort.classicInsertionSort(array, SortDirection.DESC);
        Assert.assertEquals(expected, array);
    }
}
