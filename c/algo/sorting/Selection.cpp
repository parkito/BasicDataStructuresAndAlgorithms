#include <iostream>
#include <vector>
#include "../exers/00_global/Global.h"

void sort(std::vector<int> &arr) {
    for (int i = 0; i < arr.size(); ++i) {
        int min = i;
        for (int j = i; j < arr.size(); ++j) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        std::swap(arr[i], arr[min]);
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
