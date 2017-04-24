package com.saiu.algorithms.interview.stepic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Artem Karnov @date 21.04.2017.
 *         artem.karnov@t-systems.com
 */

public class PrimeViaStreamsTest {

    @Test
    public void firstTest() {
        Assert.assertTrue(PrimeNumbersViaStreams.isPrime(5));
    }

    @Test
    public void secondTest() {
        Assert.assertTrue(PrimeNumbersViaStreams.isPrime(3));
    }

    @Test
    public void thirdTest() {
        Assert.assertTrue(PrimeNumbersViaStreams.isPrime(7));
    }

    @Test
    public void fourthTest() {
        Assert.assertTrue(PrimeNumbersViaStreams.isPrime(337));
    }

    @Test
    public void fifthTest() {
        Assert.assertFalse(PrimeNumbersViaStreams.isPrime(10));
    }

}