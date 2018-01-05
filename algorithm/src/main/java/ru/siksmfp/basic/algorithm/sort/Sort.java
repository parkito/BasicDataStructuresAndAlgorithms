package ru.siksmfp.basic.algorithm.sort;

import ru.siksmfp.basic.structure.api.ListStructure;

/**
 * @author Artem Karnov @date 21.04.2017.
 * artem.karnov@t-systems.com
 */
public class Sort {

    private Sort() {
    }

    /**
     * Classic bubble sort with default ASCENDING ordering
     *
     * @param structure structure for sorting
     * @param <T>       Type of sort elements
     */
    public static <T extends Comparable<T>> void bubbleSort(ListStructure<T> structure) {
        bubbleAscSort(structure);
    }

    /**
     * Classic bubble sorting
     *
     * @param structure     structure for sorting
     * @param sortDirection sort direction
     * @param <T>           Type of sort elements
     */
    public static <T extends Comparable<T>> void bubbleSort(ListStructure<T> structure, SortDirection sortDirection) {
        if (sortDirection == SortDirection.ASC) {
            bubbleAscSort(structure);
        } else {
            bubbleDescSort(structure);
        }
    }

    /**
     * Classic select sort with default ASCENDING ordering
     *
     * @param structure structure for sorting
     * @param <T>       Type of sort elements
     */
    public static <T extends Comparable<T>> void selectionSort(ListStructure<T> structure) {
        selectionAscSort(structure);
    }

    /**
     * Classic select sorting
     *
     * @param structure     structure for sorting
     * @param sortDirection sort direction
     * @param <T>           Type of sort elements
     */
    public static <T extends Comparable<T>> void selectionSort(ListStructure<T> structure, SortDirection sortDirection) {
        if (sortDirection == SortDirection.ASC) {
            selectionAscSort(structure);
        } else {
            selectionDescSort(structure);
        }
    }

    /**
     * Bubble sorting with ASCENDING ordering
     *
     * @param structure structure for sorting
     * @param <T>       Type of sort elements
     */
    private static <T extends Comparable<T>> void bubbleDescSort(ListStructure<T> structure) {
        for (int i = 0; i < structure.size(); i++) {
            for (int j = i; j < structure.size(); j++) {
                if (structure.get(i).compareTo(structure.get(j)) < 0) {
                    swap(structure, i, j);

                }
            }
        }
    }

    /**
     * Bubble sorting with DESCENDING ordering
     *
     * @param structure structure for sorting
     * @param <T>       Type of sort elements
     */
    private static <T extends Comparable<T>> void bubbleAscSort(ListStructure<T> structure) {
        for (int i = 0; i < structure.size(); i++) {
            for (int j = i; j < structure.size(); j++) {
                if (structure.get(i).compareTo(structure.get(j)) > 0) {
                    swap(structure, i, j);
                }
            }
        }
    }

    private static <T extends Comparable<T>> void selectionAscSort(ListStructure<T> structure) {
        for (int i = 0; i < structure.size(); i++) {
            int localIndexMin = i;
            for (int j = i; j < structure.size(); j++) {
                if (structure.get(j).compareTo(structure.get(localIndexMin)) < 0) {
                    localIndexMin = j;
                }
            }
            swap(structure, localIndexMin, i);
        }
    }

    private static <T extends Comparable<T>> void selectionDescSort(ListStructure<T> structure) {
        for (int i = 0; i < structure.size(); i++) {
            int localIndexMax = i;
            for (int j = i; j < structure.size(); j++) {
                if (structure.get(j).compareTo(structure.get(localIndexMax)) > 0) {
                    localIndexMax = j;
                }
            }
            swap(structure, localIndexMax, i);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(ListStructure<T> structure, SortDirection sortDirection) {
        if (sortDirection == SortDirection.ASC) {
            insertionAscSort(structure);
        } else {
            insertionDescSort(structure);
        }
    }

    private static <T extends Comparable<T>> void insertionAscSort(ListStructure<T> structure) {
        for (int i = 0; i < structure.size(); i++) {
            int leftIndex = getLeftBorder(structure, i);
            rightShift(structure, leftIndex, i);
        }
    }

    private static <T extends Comparable<T>> void insertionDescSort(ListStructure<T> structure) {
        for (int i = 0; i < structure.size(); i++) {
            int leftIndex = getRightBorder(structure, i);
            rightShift(structure, leftIndex, i);
        }
    }

    private static <T extends Comparable<T>> void rightShift(ListStructure<T> structure, int leftIndex, int rightIndex) {
        T localMinValue = structure.get(rightIndex);
        for (int i = rightIndex; i > leftIndex; i--) {
            structure.add(i, structure.get(i - 1));
        }
        structure.add(leftIndex, localMinValue);
    }

    private static <T extends Comparable<T>> int getLeftBorder(ListStructure<T> structure, int rightIndex) {
        for (int i = rightIndex - 1; i >= 0; i--) {
            if (structure.get(rightIndex).compareTo(structure.get(i)) > 0)
                return i + 1;
        }
        return 0;
    }

    private static <T extends Comparable<T>> int getRightBorder(ListStructure<T> structure, int rightIndex) {
        for (int i = rightIndex - 1; i >= 0; i--) {
            if (structure.get(rightIndex).compareTo(structure.get(i)) < 0)
                return i + 1;
        }
        return 0;
    }


    /**
     * Classic element swapping
     *
     * @structure structure for swapping
     * @index1 e1 first element
     * @index2 e2 second element
     */
    private static <T extends Comparable<T>> void swap(ListStructure<T> structure, int index1, int index2) {
        if (index1 != index2) {
            T temp = structure.get(index1);
            structure.add(index1, structure.get(index2));
            structure.add(index2, temp);
        }
    }

//    private static long[] array;
//
//    public Sort(long[] array) {
//        this.array = array;
//    }
//
//    public static long[] bubbleSort1() {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    swap(j, j + 1);
//                }
//            }
//        }
//        return array;
//    }
//
//    public static long[] insertSort() {
//        for (int i = 0; i < array.length; i++) {
//            int j = i;
//            while (j > 0) {
//                if (array[j] < array[j - 1]) {
//                    swap(j, j - 1);
//                }
//                j--;
//            }
//        }
//        return array;
//    }
//
//    private static void swap(int index1, int index2) {
//        long temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }

//    public void shellSort(long[] array) {
//        int inner, outer;
//        long temp;
//
//        int h = 1;
//        while (h <= array.length / 3)
//            h = h * 3 + 1;
//        while (h > 0) {
//            for (outer = h; outer < array.length; outer++) {
//                temp = array[outer];
//                inner = outer;
//                while (inner > h - 1 && array[inner - h] >= temp) {
//                    array[inner] = array[inner - h];
//                    inner -= h;
//                }
//                array[inner] = temp;
//            }
//            h = (h - 1) / 3;
//        }
//    }
//
//    public int partitionIt(int left, int right, long pivot) {
//        int leftPtr = left - 1;
//        int rightPtr = right;
//        while (true) {
//            while (array[++leftPtr] < pivot) ;
//            while (rightPtr > 0 && array[--rightPtr] > pivot) ;
//
//            if (leftPtr >= rightPtr)
//                break;
//            else
//                swap(leftPtr, rightPtr);
//        }
//        swap(leftPtr, right);
//        return leftPtr;


//    }


}

