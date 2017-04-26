package com.saiu.algorithms.interview.stepic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * @author Artem Karnov @date 25.04.2017.
 *         artem.karnov@t-systems.com
 */

public class DeckSkipWithStream {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4));
        Deque<Integer> queue_2 = queue.stream().skip(2)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
