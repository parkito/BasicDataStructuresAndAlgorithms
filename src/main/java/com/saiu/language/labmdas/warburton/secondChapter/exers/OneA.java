package warburton.secondChapter.exers;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by Artyom Karnov on 27.11.16.
 * artyom-karnov@yandex.ru
 **/
public class OneA {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 55);
        OneA oneA = new OneA();
        System.out.println(oneA.addUp(stream));

    }

    int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (one, two) -> one + two);
    }
}

class One {
    public static void main(String[] args) {
        warburton.thirdChapter.exer.One one = new warburton.thirdChapter.exer.One();
        List<Integer> numbers = asList(1, 2, 3);
        System.out.println(one.addUp(numbers.stream()));
    }

    public int addUp(Stream<Integer> numbers) {
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        return numbers.reduce(sum).get();
    }
}