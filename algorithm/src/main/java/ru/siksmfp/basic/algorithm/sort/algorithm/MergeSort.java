package ru.siksmfp.basic.algorithm.sort.algorithm;

import ru.siksmfp.basic.algorithm.sort.SortDirection;
import ru.siksmfp.basic.structure.api.ArrayStructure;
import ru.siksmfp.basic.structure.array.FixedArray;

public class MergeSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {

    @Override
    public void sort(ArrayStructure<T> structure, SortDirection direction) {
        ArrayStructure<T> fixed = new FixedArray<T>(structure.size());
        recMerge(structure, fixed, direction, 0, structure.size() - 1);
    }

    private void recMerge(ArrayStructure<T> structure, ArrayStructure<T> fixed, SortDirection direction, int from, int to) {
        if (from == to) {
            return;
        }

        int mid = (from + to) / 2;

        recMerge(structure, fixed, direction, from, mid);
        recMerge(structure, fixed, direction, mid + 1, to);

        merge(structure, fixed, direction, from, mid + 1, to);
    }


    private void merge(ArrayStructure<T> arr, SortDirection direction, int from, int mid, int to) {
    }

    public static void main(String[] args) {
    }
}
