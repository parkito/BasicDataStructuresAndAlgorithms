#include <iostream>
#include <vector>
#include "Global.h"

void sort(std::vector<int> &arr) {
    int h = 1;
    while (h < arr.size() / 3) {
        h = 3 * h + 1;
    }
    while (h >= 1) {
        for (int i = h; i < arr.size(); ++i) {
            for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                std::swap(arr[j], arr[j - h]);
            }
        }
        h /= 3;
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
