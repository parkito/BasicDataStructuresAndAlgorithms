package ru.siksmfp.basic.algorithm.sort.algorithm;

import ru.siksmfp.basic.algorithm.sort.SortDirection;
import ru.siksmfp.basic.algorithm.sort.SortUtils;
import ru.siksmfp.basic.structure.api.ArrayStructure;
import ru.siksmfp.basic.structure.array.FixedArray;

public class MergeSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {

    @Override
    public void sort(ArrayStructure<T> structure, SortDirection direction) {
        if (structure.isEmpty()) {
            return;
        }
        ArrayStructure<T> fixed = new FixedArray<T>(structure.size());
        recMerge(structure, fixed, direction, 0, structure.size() - 1);
    }

    private void recMerge(ArrayStructure<T> arr, ArrayStructure<T> fixed, SortDirection direction, int from, int to) {
        if (from == to) {
            return;
        }

        int mid = (from + to) / 2;

        recMerge(arr, fixed, direction, from, mid);
        recMerge(arr, fixed, direction, mid + 1, to);

        merge(arr, fixed, direction, from, mid + 1, to);
    }

    private void merge(ArrayStructure<T> arr, ArrayStructure<T> fixed, SortDirection direction, int from, int mid, int to) {
        int i = 0;
        int lowerBound = from;
        int upperBound = mid;
        int curMid = mid - 1;
        int elements = to - from + 1;

        while (lowerBound <= curMid && upperBound <= to) {
            if (SortUtils.shallSort(arr.get(lowerBound), arr.get(upperBound), direction)) {
                fixed.add(i++, arr.get(upperBound++));
            } else {
                fixed.add(i++, arr.get(lowerBound++));
            }
        }

        while (lowerBound <= curMid) {
            fixed.add(i++, arr.get(lowerBound++));
        }

        while (upperBound <= to) {
            fixed.add(i++, arr.get(upperBound++));
        }

        for (int j = 0; j < elements; j++) {
            arr.add(from + j, fixed.get(j));
        }
    }
}
