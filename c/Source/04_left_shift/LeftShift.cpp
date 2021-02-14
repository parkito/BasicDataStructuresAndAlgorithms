#include "../00_global/Global.h"

std::vector<int> rotateLeft(int d, std::vector<int> arr) {
    int shifts = d % arr.size();
    if (arr.size() <= 1 || shifts == 0) {
        return arr;
    }
    int newPos;
    int arrSize = (int) arr.size();
    auto result = std::vector<int>(arrSize);
    for (int i = 0; i < arrSize; ++i) {
        int diff = i - shifts;
        if (diff >= 0) {
            newPos = diff;
        } else {
            newPos = arrSize + diff;
        }
        result[newPos] = arr[i];
    }
    return result;
}

int main() {
    global::print(rotateLeft(10, {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51}));
    global::print(rotateLeft(1, {1, 2, 3, 4, 5}));
    global::print(rotateLeft(1, {1, 2}));
    global::print(rotateLeft(2, {1, 2}));
}
