package ru.siksmfp.basic.algorithm.sort.algorithm;

import ru.siksmfp.basic.algorithm.sort.SortDirection;
import ru.siksmfp.basic.structure.api.ArrayStructure;

import static ru.siksmfp.basic.algorithm.sort.SortUtils.shallSort;
import static ru.siksmfp.basic.algorithm.sort.SortUtils.swap;

public class BubbleSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {

    @Override
    public void sort(ArrayStructure<T> structure, SortDirection direction) {
        for (int i = 0; i < structure.size(); i++) {
            for (int j = 0; j < structure.size() - i - 1; j++) {
                if (shallSort(structure.get(j), structure.get(j + 1), direction)) {
                    swap(structure, j, j + 1);
                }
            }
        }
    }
}
