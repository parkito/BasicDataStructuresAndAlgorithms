#include "../00_global/Global.h"


std::vector<int> reverseArray(std::vector<int> vector) {
    for (int i = 0; i < vector.size() / 2; ++i) {
        global::swap(vector[i], vector[vector.size() - i - 1]);
    }

    return vector;
}

int main() {
    global::print(reverseArray({1, 2, 3, 4}));
    std::cout << std::endl;
    global::print(reverseArray({1, 2, 3}));
}

