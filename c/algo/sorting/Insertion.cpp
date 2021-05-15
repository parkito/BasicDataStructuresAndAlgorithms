#include <iostream>
#include <vector>
#include "../../Source/00_global/Global.h"

void sort(std::vector<int> &arr) {
    if (arr.size() <= 1) {
        return;
    }
    for (int i = 1; i < arr.size(); ++i) {
        for (int j = i; arr[j] < arr[j - 1]; ++j) {
            std::swap(arr[j], arr[j - 1]);
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
