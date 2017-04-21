package com.saiu.algorithms.interview.stepic;

/**
 * @author Artem Karnov @date 21.04.2017.
 * artem.karnov@t-systems.com
 */

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimeViaStreams {

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    public static boolean isPrime(final long number) {
        return !Stream.iterate(2, n -> n + 1).limit(number - 2).filter(i -> number % i == 0).findFirst().isPresent();
    }

    //shortest solution
    public static boolean isPrimeOne(final long number) {
        return LongStream.range(2, number)
                .filter(x -> number % x == 0)
                .count() == 0;
    }

    //effective
    public static boolean isPrimeTwo(final long number) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
