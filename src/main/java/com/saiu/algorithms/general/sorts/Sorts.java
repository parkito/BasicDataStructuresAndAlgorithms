package com.saiu.algorithms.general.sorts;

/**
 * @author Artem Karnov @date 21.04.2017.
 *         artem.karnov@t-systems.com
 */
// TODO: 22.04.17 Generics and auto comparable
public class Sorts {

    private static long[] array;

    public Sorts(long[] array) {
        this.array = array;
    }

    public static long[] bubbleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        return array;
    }

    public static long[] insertSort() {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0) {
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1);
                }
                j--;
            }
        }
        return array;
    }

    private static void swap(int index1, int index2) {
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

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

