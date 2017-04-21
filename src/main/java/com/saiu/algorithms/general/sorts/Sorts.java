package com.saiu.algorithms.general.sorts;

/**
 * @author Artem Karnov @date 21.04.2017.
 *         artem.karnov@t-systems.com
 */

public class Sorts {
    private long A[];
    int sizeofarray;

    public void insertSort() {
        {
            int in, out;
            for (out = 1; out < sizeofarray; out++) {
                long temp = A[out];
                in = out;
                while (in > 0 && A[in - 1] >= temp) {
                    A[in] = A[in - 1];
                    --in;
                }
                A[in] = temp;
            }
        }
    }


    public void bubbleSort() {
        for (int i = 0; i < sizeofarray; i++) {
            for (int j = 0; j < sizeofarray - 1; j++) {
                if (A[j] > A[j + 1]) {
                    long temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }


    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;                     // find initial value of h
        while (h <= sizeofarray / 3)
            h = h * 3 + 1;                // (1, 4, 13, 40, 121, ...)

        while (h > 0)                     // decreasing h, until h=1
        {
            // h-sort the file
            for (outer = h; outer < sizeofarray; outer++) {
                temp = A[outer];
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while (inner > h - 1 && A[inner - h] >= temp) {
                    A[inner] = A[inner - h];
                    inner -= h;
                }
                A[inner] = temp;
            }  // end for
            h = (h - 1) / 3;              // decrease h
        }  // end while(h>0)
    }  // end shellSort()


    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;           // left    (after ++)
        int rightPtr = right;           // right-1 (after --)
        while (true) {                            // find bigger item
            while (A[++leftPtr] < pivot)
                ;  // (nop)
            // find smaller item
            while (rightPtr > 0 && A[--rightPtr] > pivot)
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
    public void swap(int dex1, int dex2)  // swap two elements
    {
        long temp = A[dex1];        // A into temp
        A[dex1] = A[dex2];   // B into A
        A[dex2] = temp;             // temp into B
    }  // end swap(


}

