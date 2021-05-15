#include <iostream>
#include <vector>
#include "Global.h"

void sort(std::vector<int> &arr) {

}

void merge(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &mid, const int &hi) {
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
        } else {
            arr[i] = supArr[left++];
        }
    }
}

void topToDown(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &hi) {
    if (hi <= lo) {
        return;
    }
    int mid = lo + (hi - lo) / 2;
    topToDown(arr, supArr, lo, mid);
    topToDown(arr, supArr, mid + 1, hi);
    merge(arr, supArr, lo, mid, hi);
}

void downToTop(std::vector<int> &arr, std::vector<int> &supArr, const int &lo, const int &hi, long &counter) {
    for (int i = 1; i < arr.size(); i = i + i) {
        for (int j = 0; j < arr.size() - i; j += i + i) {
            merge(arr, supArr, j, j + i - 1, std::min(j + i + i - 1, int(arr.size() - 1)));
        }
    }
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
