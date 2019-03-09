package ru.siksmfp.basic.algorithm.sort.algorithm;

import ru.siksmfp.basic.algorithm.sort.SortDirection;
import ru.siksmfp.basic.structure.api.ArrayStructure;

import static ru.siksmfp.basic.algorithm.sort.SortDirection.ASC;
import static ru.siksmfp.basic.algorithm.sort.SortUtils.findMax;
import static ru.siksmfp.basic.algorithm.sort.SortUtils.swap;

public class SelectionSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {

    @Override
    public void sort(ArrayStructure<T> structure, SortDirection direction) {
        if (direction == ASC) {
            for (int i = structure.size() - 1; i >= 0; i--) {
                int localMax = findMax(structure, 0, i);
                swap(structure, i, localMax);
            }
        } else {
            for (int i = 0; i < structure.size(); i++) {
                int localMin = findMax(structure, i, structure.size());
                swap(structure, i, localMin);
            }
        }
    }
}
