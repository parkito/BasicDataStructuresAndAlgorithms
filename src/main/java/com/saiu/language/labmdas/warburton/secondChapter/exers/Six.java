package com.saiu.language.labmdas.warburton.secondChapter.exers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Artem Karnov @date 28.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class Six {
    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.countLowerCases("GGhelloGG"));
        Optional<String> optional = six.findLongestLowerCaseString(Arrays.asList("hello", "kjdshfdehkfhhds"));
        System.out.println(optional.get());

    }

    public static long countLowerCases(String string) {
        Stream<String> stringStream = Stream.of(string);
        long result = string.chars().filter(Character::isLowerCase).count();
        return result;
    }

    public Optional<String> findLongestLowerCaseString(List<String> strings) {
        return strings.stream().max(Comparator.comparing(Six::countLowerCases));
    }
}
