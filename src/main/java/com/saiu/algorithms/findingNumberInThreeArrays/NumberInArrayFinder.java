package com.saiu.algorithms.findingNumberInThreeArrays;

import com.saiu.dataStructures.fixedArray.FixedArray;

/**
 * @author Artem Karnov @date 25.02.17.
 *         artem.karnov@t-systems.com
 */

public class NumberInArrayFinder<T> {
    private int firstIndex = 0, secondIndex = 0, thirdIndex = 0, localMax = 0, result = 0;

    public int find(FixedArray<T> firstArray, FixedArray<T> secondArray, FixedArray<T> thirdArray) {
        while (firstIndex < firstArray.size() && secondIndex < secondArray.size()
                && thirdIndex < thirdArray.size()) {

            localMax = getMax((Integer) firstArray.get(firstIndex),
                    (Integer) secondArray.get(secondIndex), (Integer) thirdArray.get(thirdIndex));

            equalize(firstArray, secondArray, thirdArray);

            if (compare((Integer) firstArray.get(firstIndex),
                    (Integer) secondArray.get(secondIndex), (Integer) thirdArray.get(thirdIndex)))
                return (Integer) firstArray.get(firstIndex);
            else {
                if (firstIndex == firstArray.size() - 1 &&
                        secondIndex == secondArray.size() - 1 &&
                        thirdIndex == thirdArray.size() - 1)
                    return 0;
                else {
                    return find(firstArray, secondArray, thirdArray);
                }
            }

        }
        return result;
    }

    private int getMax(int first, int second, int third) {
        if (first > second) {
            if (first > third)
                return first;
            else
                return third;
        } else {
            if (second > third)
                return second;
            else
                return third;
        }
    }

    private void equalize(FixedArray<T> firstArray, FixedArray<T> secondArray, FixedArray<T> thirdArray) {
        while (localMax > (Integer) firstArray.get(firstIndex) && firstIndex < firstArray.size() - 1) {
            firstIndex++;
        }

        while (localMax > (Integer) secondArray.get(secondIndex) && secondIndex < secondArray.size() - 1) {
            secondIndex++;
        }

        while (localMax > (Integer) thirdArray.get(thirdIndex) && thirdIndex < thirdArray.size() - 1) {
            thirdIndex++;
        }
    }

    private boolean compare(int first, int second, int third) {
        if (first == second && first == third)
            return true;
        else
            return false;
    }


}
