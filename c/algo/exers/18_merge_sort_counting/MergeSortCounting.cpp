#include <iostream>
#include <vector>

long _mergeSort(std::vector<int> &arr, std::vector<int> &temp, int left, int right);

long merge(std::vector<int> &, std::vector<int> &temp, int left, int mid, int right);

long mergeSort(std::vector<int> &arr) {
    std::vector<int> tmp(arr.size());
    return _mergeSort(arr, tmp, 0, arr.size() - 1);
}

long _mergeSort(std::vector<int> &arr, std::vector<int> &temp, int left, int right) {
    int mid;
    long inv_count = 0;
    if (right > left) {
        mid = (right + left) / 2;
        inv_count += _mergeSort(arr, temp, left, mid);
        inv_count += _mergeSort(arr, temp, mid + 1, right);
        inv_count += merge(arr, temp, left, mid + 1, right);
    }
    return inv_count;
}

long merge(std::vector<int> &arr, std::vector<int> &temp, int left, int mid, int right) {
    long inv_count = 0;
    int i = left;
    int j = mid;
    int k = left;

    while ((i <= mid - 1) && (j <= right)) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
            inv_count = inv_count + (mid - i);
        }
    }

    while (i <= mid - 1)
        temp[k++] = arr[i++];

    while (j <= right)
        temp[k++] = arr[j++];

    for (i = left; i <= right; i++)
        arr[i] = temp[i];

    return inv_count;
}

long countInversions(std::vector<int> arr) {
    return mergeSort(arr);
}

int main() {
    std::cout << countInversions({2, 4, 1}) << std::endl; //2
    std::cout << countInversions({1, 1, 1, 2, 2}) << std::endl; //0
    std::cout << countInversions({2, 1, 3, 1, 2}) << std::endl; //4
    std::cout << countInversions({1, 5, 3, 7}) << std::endl; //1
    std::cout << countInversions({7, 5, 3, 1}) << std::endl; //6
}
