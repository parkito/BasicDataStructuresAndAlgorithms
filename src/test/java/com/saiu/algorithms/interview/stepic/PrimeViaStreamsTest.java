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
        Assert.assertTrue(PrimeViaStreams.isPrime(5));
    }

    @Test
    public void secondTest() {
        Assert.assertTrue(PrimeViaStreams.isPrime(3));
    }

    @Test
    public void thirdTest() {
        Assert.assertTrue(PrimeViaStreams.isPrime(7));
    }

    @Test
    public void fourthTest() {
        Assert.assertTrue(PrimeViaStreams.isPrime(337));
    }

    @Test
    public void fifthTest() {
        Assert.assertFalse(PrimeViaStreams.isPrime(10));
    }

}