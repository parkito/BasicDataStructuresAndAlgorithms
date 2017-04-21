package com.saiu.algorithms.general.sorts;

/**
 * @author Artem Karnov @date 21.04.2017.
 *         artem.karnov@t-systems.com
 */

public class Sorts {
    private long array[];

    public void bubbleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    long temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
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

        int h = 1;                     // find initial value of h
        while (h <= array.length / 3)
            h = h * 3 + 1;                // (1, 4, 13, 40, 121, ...)

        while (h > 0)                     // decreasing h, until h=1
        {
            // h-sort the file
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }  // end for
            h = (h - 1) / 3;              // decrease h
        }  // end while(h>0)
    }  // end shellSort()


    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;           // left    (after ++)
        int rightPtr = right;           // right-1 (after --)
        while (true) {                            // find bigger item
            while (array[++leftPtr] < pivot)
                ;  // (nop)
            // find smaller item
            while (rightPtr > 0 && array[--rightPtr] > pivot)
                ;  // (nop)

            if (leftPtr >= rightPtr)      // if pointers cross,
                break;                    //    partition done
            else                         // not crossed, so
                swap(leftPtr, rightPtr);  //    swap elements
        }  // end while(true)
        swap(leftPtr, right);           // restore pivot
        return leftPtr;                 // return pivot location
    }  // end partitionIt()

    //--------------------------------------------------------------
    private void swap(int dex1, int dex2)  // swap two elements
    {
        long temp = array[dex1];        // array into temp
        array[dex1] = array[dex2];   // B into array
        array[dex2] = temp;             // temp into B
    }  // end swap(


}

