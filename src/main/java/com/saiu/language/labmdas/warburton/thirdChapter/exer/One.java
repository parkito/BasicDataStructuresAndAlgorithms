package com.saiu.language.labmdas.warburton.thirdChapter.exer;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author Artem Karnov @date 31.01.2017.
 *         artem.karnov@t-systems.com
 */

public class One {
    public static void main(String[] args) {
        One one = new One();
        List<Integer> numbers = asList(1, 2, 3);
        System.out.println(one.addUp(numbers.stream()));
    }

    public int addUp(Stream<Integer> numbers) {
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        return numbers.reduce(sum).get();
    }
}
