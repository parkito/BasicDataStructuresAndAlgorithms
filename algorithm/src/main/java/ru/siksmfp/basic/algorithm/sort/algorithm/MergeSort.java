package ru.siksmfp.basic.algorithm.sort.algorithm;

import ru.siksmfp.basic.algorithm.sort.SortDirection;
import ru.siksmfp.basic.algorithm.sort.SortUtils;
import ru.siksmfp.basic.structure.api.ArrayStructure;

public class MergeSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {

    @Override
    public void sort(ArrayStructure<T> structure, SortDirection direction) {
        recMerge(structure, direction, 0, structure.size());
    }

    private void recMerge(ArrayStructure<T> structure, SortDirection direction, int from, int to) {
        if (from == to) {
            return;
        }

        int mid = (from + to) / 2;

        recMerge(structure, direction, from, mid);
        recMerge(structure, direction, mid + 1, to);

        merge(structure, direction, from, mid + 1, to);
    }


    private void merge(ArrayStructure<T> arr, SortDirection direction, int from, int mid, int to) {
        int lowerBound = from;
        int upperBound = mid;

        while (lowerBound < mid && upperBound < to) {
            if (SortUtils.shallSort(arr.get(lowerBound), arr.get(upperBound), direction)) {
                SortUtils.swap(arr, lowerBound, upperBound);
                lowerBound++;
            } else {
                lowerBound++;
                upperBound++;
            }
        }
    }

    public static void main(String[] args) {
    }
}
