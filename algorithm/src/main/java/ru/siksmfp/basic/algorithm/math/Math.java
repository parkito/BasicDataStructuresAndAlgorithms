package ru.siksmfp.basic.algorithm.math;

/**
 * @author Artem Karnov @date 1/6/2018.
 * artem.karnov@t-systems.com
 */
public class Math {
    public static double pow(double base, double exponent) {
        // TODO: 1/6/2018  make your own realization
        return java.lang.Math.pow(base, exponent);
    }

    public static int[] getFirstSimpleNumberBefore(int before) {
        int arr[] = new int[before];
        int i = 0;
        for (int k = 3; k <= before; k += 2, i++) {
            arr[i] = k;
        }

        for (int k = 0; k < i; k++) {
            for (int h = 3, j = arr[k] * h; h < i; h += 2, j = arr[k] * h) {
                deleteFromArray(arr, j);
            }

        }
        return arr;
    }

    private static void deleteFromArray(int arr[], int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        for (int i : getFirstSimpleNumberBefore(3000))
            System.out.print(i + " ");
    }
}
