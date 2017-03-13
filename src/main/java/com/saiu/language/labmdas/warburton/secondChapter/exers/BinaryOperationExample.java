package com.saiu.language.labmdas.warburton.secondChapter.exers;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by Artyom Karnov on 27.11.16.
 * artyom-karnov@yandex.ru
 **/
public class BinaryOperationExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 55);
        BinaryOperationExample oneA = new BinaryOperationExample();
        System.out.println(oneA.addUp(stream));

    }

    int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (one, two) -> one + two);
    }
}

