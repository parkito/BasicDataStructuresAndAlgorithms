#include <iostream>
#include <vector>
#include "../00_global/Global.h"

void swap(std::vector<int> &arr, const int &i, const int &j, long &counter) {
    auto tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
    counter++;
}

void
merge1(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &mid, const int &hi, long &counter) {
    for (int i = lo; i <= hi; ++i) {
        supArr[i] = arr[i];
    }
    int left = lo;
    int right = mid + 1;
    for (int i = lo; i <= hi; ++i) {
        if (left > mid) {
            arr[i] = supArr[right++];
        } else if (right > hi) {
            arr[i] = supArr[left++];
        } else if (supArr[right] < supArr[left]) {
            arr[i] = supArr[right++];
            counter += mid - i;
        } else {
            arr[i] = supArr[left++];
        }
    }
}

void sort1(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &hi, long &counter) {
    if (hi <= lo) {
        return;
    }
    int mid = lo + (hi - lo) / 2;
    sort1(arr, supArr, lo, mid, counter);
    sort1(arr, supArr, mid + 1, hi, counter);
    merge1(arr, supArr, lo, mid, hi, counter);
}

void sort2(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &hi, long &counter) {
    for (int i = 1; i < arr.size(); i = i + i) {
        for (int j = 0; j < arr.size() - i; j += i + i) {
            merge1(arr, supArr, j, j + i - 1, std::min(j + i + i - 1, int(arr.size() - 1)), counter);
        }
    }
}

int startSort(std::vector<int> arr) {
    long counter = 0;
    std::vector<int> supArr(arr.size());
    sort2(arr, supArr, 0, arr.size() - 1, counter);
    return counter;
}


int partition(std::vector<int> &arr, int &lo, int &hi, long &counter) {
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
            swap(arr, i, j, counter);
        }
    }
    if (arr[lo] != arr[j]) {
        swap(arr, lo, j, counter);
    }
    return j;
}

void quickSort(std::vector<int> &arr, int lo, int hi, long &counter) {
    if (hi <= lo) {
        return;
    }
    int j = partition(arr, lo, hi, counter);
    quickSort(arr, lo, j - 1, counter);
    quickSort(arr, j + 1, hi, counter);
}

long merge(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &mid, const int &hi) {
    long counter = 0;
    for (int i = lo; i <= hi; ++i) {
        supArr[i] = arr[i];
    }
    int left = lo;
    int right = mid + 1;
    for (int i = lo; i <= hi; ++i) {
        if (left > mid) {
            arr[i] = supArr[right++];
        } else if (right > hi) {
            arr[i] = supArr[left++];
        } else if (supArr[right] < supArr[left]) {
            counter = counter + mid - 1;
            arr[i] = supArr[right++];
        } else {
            arr[i] = supArr[left++];
        }
    }
    return counter;
}

long sort(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &hi) {
    long counter = 0;
    if (hi <= lo) {
        return counter;
    }
    int mid = lo + (hi - lo) / 2;
    counter += sort(arr, supArr, lo, mid);
    counter += sort(arr, supArr, mid + 1, hi);
    counter += merge(arr, supArr, lo, mid, hi);
    return counter;
}

long countInversions(std::vector<int> arr) {
    std::vector<int> tmp(arr.size());
    return sort(arr, tmp, 0, arr.size() - 1);
}

int main() {
    std::cout << countInversions({2, 4, 1}) << std::endl; //2
    std::cout << countInversions({1, 1, 1, 2, 2}) << std::endl; //0
    std::cout << countInversions({2, 1, 3, 1, 2}) << std::endl; //4
    std::cout << countInversions({1, 5, 3, 7}) << std::endl; //1
    std::cout << countInversions({7, 5, 3, 1}) << std::endl; //6
}
