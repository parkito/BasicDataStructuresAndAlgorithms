package com.saiu.algorithms.interview.codeWars;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Artem Karnov @date 10/27/2017.
 * artem.karnov@t-systems.com
 */
public class SimpleReversalTest {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, SimpleReversal.reverse(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{0}, SimpleReversal.reverse(new int[]{0}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{}, SimpleReversal.reverse(new int[]{}));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{1842509479}, SimpleReversal.reverse(new int[]{1842509479}));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[]{1, 8, 4, 2, 5, 0, 9, 4, 7, 9}, SimpleReversal.reverse(new int[]{9, 7, 4, 9, 0, 5, 2, 4, 8, 1}));
    }
}