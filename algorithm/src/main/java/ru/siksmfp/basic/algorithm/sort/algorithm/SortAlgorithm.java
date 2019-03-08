package ru.siksmfp.basic.algorithm.sort.algorithm;

import ru.siksmfp.basic.algorithm.sort.SortDirection;
import ru.siksmfp.basic.structure.api.ArrayStructure;

public interface SortAlgorithm<T extends Comparable> {

    void sort(ArrayStructure<T> structure, SortDirection direction);
}
