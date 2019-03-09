package ru.siksmfp.basic.algorithm.sort.algorithm;

import ru.siksmfp.basic.algorithm.sort.SortDirection;
import ru.siksmfp.basic.structure.api.ArrayStructure;

import static ru.siksmfp.basic.algorithm.sort.SortUtils.shallSort;
import static ru.siksmfp.basic.algorithm.sort.SortUtils.swap;

public class InsertionSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {

    @Override
    public void sort(ArrayStructure<T> structure, SortDirection direction) {
        for (int i = 0; i < structure.size(); i++) {
            int currentLine = i;
            while (currentLine > 0 && shallSort(structure.get(currentLine - 1), structure.get(currentLine), direction)) {
                swap(structure, currentLine - 1, currentLine);
                currentLine--;
            }
        }
    }
}
