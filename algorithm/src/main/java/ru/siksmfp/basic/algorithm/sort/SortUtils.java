package ru.siksmfp.basic.algorithm.sort;

import ru.siksmfp.basic.structure.api.ArrayStructure;

import static ru.siksmfp.basic.algorithm.sort.SortDirection.ASC;

public class SortUtils {

    public static <T extends Comparable<? super T>> boolean shallSort(T comp1, T comp2, SortDirection order) {
        if (order == ASC) {
            return comp1.compareTo(comp2) > 0;
        } else {
            return comp1.compareTo(comp2) < 0;
        }
    }

    public static <T extends Comparable> void swap(ArrayStructure<T> structure, int index1, int index2) {
        T temp = structure.get(index1);
        structure.add(index1, structure.get(index2));
        structure.add(index2, temp);
    }
}
