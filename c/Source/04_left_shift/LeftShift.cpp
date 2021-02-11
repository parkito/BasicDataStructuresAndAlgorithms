#include "../00_global/Global.h"

std::vector<int> rotateLeft(int d, std::vector<int> arr) {
    int shifts = d % arr.size();
    if (arr.size() <= 1 || shifts == 0) {
        return arr;
    }
    int newPos;
    int replacedVal;
    int arrSize = (int) arr.size();
    for (int i = 0; i < arrSize; ++i) {
        int diff = i - shifts;
        if (diff >= 0) {
            newPos = diff;
        } else {
            newPos = arrSize + diff;
        }

        if (i == 0) {
            replacedVal = arr[newPos];
            arr[newPos] = arr[i];
        } else {
            int tmp = arr[newPos];
            arr[newPos] = replacedVal;
            replacedVal = tmp;
        }
    }
    return arr;
}

int main() {
    global::print(rotateLeft(4, {1, 2, 3, 4, 5}));
    global::print(rotateLeft(1, {1, 2, 3, 4, 5}));
    global::print(rotateLeft(1, {1, 2}));
    global::print(rotateLeft(2, {1, 2}));
}
