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
merge(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &mid, const int &hi, long &counter) {
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
            counter++;
        } else {
            arr[i] = supArr[left++];
            counter++;
        }
    }
}

void sort(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &hi, long &counter) {
    if (hi <= lo) {
        return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(arr, supArr, lo, mid, counter);
    sort(arr, supArr, mid + 1, hi, counter);
    merge(arr, supArr, lo, mid, hi, counter);
}

long countInversions(std::vector<int> arr) {
    std::vector<int> supArr(arr.size());
    long counter = 0;
    sort(arr, supArr, 0, arr.size() - 1, counter);
    return counter;
}

int main() {
    std::cout << countInversions({2, 4, 1}) << std::endl; //2
    std::cout << countInversions({1, 1, 1, 2, 2}) << std::endl; //0
    std::cout << countInversions({2, 1, 3, 1, 2}) << std::endl; //4
}
