#include <iostream>
#include <vector>
#include "../../Source/00_global/Global.h"


int partition(std::vector<int> &arr, int &lo, int &hi) {
    int i = lo;
    int j = hi + 1;
    int v = arr[lo];
    while (true) {
        while (arr[++i] < v) {
            if (j == hi) {
                break;
            }
        }
        while (v < arr[--j]) {
            if (j == lo) {
                break;
            }
        }
        if (i >= j) {
            break;
        }
        if (arr[i] != arr[j]) {
            std::swap(arr[i], arr[j]);
        }
    }
    if (arr[lo] != arr[j]) {
        std::swap(arr[lo], arr[j]);
    }
    return j;
}

void quickSort(std::vector<int> &arr, int lo, int hi) {
    if (hi <= lo) {
        return;
    }
    int j = partition(arr, lo, hi);
    quickSort(arr, lo, j - 1);
    quickSort(arr, j + 1, hi);
}

void sort(std::vector<int> &arr) {
    quickSort(arr, 0, arr.size());
}

int main() {
    std::vector<int> vec1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sort(vec1);
    global::print(vec1);
    std::cout << std::endl;
    std::vector<int> vec2 = {1, 2, 3, 0, 0, 1, 3, 5, -1};
    sort(vec2);
    global::print(vec2);
}
