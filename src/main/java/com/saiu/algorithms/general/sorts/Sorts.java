package com.saiu.algorithms.general.sorts;

/**
 * @author Artem Karnov @date 21.04.2017.
 *         artem.karnov@t-systems.com
 */

public class Sorts {
    private static long[] array;

    public Sorts(long[] list) {
        array = list;
    }

    public static long[] bubbleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {
                    long temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;

    }


    public void insertSort() {
        int in, out = 0;

//        for (int i = 0; i < array.length; i++) {
//            long temp = array[i];
//            if (temp > array[i + 1]) {
//                out = i;
//                while (out >= 0) {
//                    if (array[out]<)
//                }
//            }
//
//        }

        for (out = 1; out < array.length; out++) {
            long temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }


    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;
        while (h <= array.length / 3)
            h = h * 3 + 1;
        while (h > 0) {
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;
                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }


    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (array[++leftPtr] < pivot) ;
            while (rightPtr > 0 && array[--rightPtr] > pivot) ;

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }


    private void swap(int dex1, int dex2) {
        long temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }


}

