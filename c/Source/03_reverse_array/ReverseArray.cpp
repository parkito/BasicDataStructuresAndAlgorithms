#include <iostream>
#include <vector>

void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
}

std::vector<int> reverseArray(std::vector<int> vector) {
    for (int i = 0; i < vector.size() / 2; ++i) {
        swap(vector[i], vector[vector.size() - i - 1]);
    }

    return vector;
}

void print(const std::vector<int> &vector) {
    for (auto &vec :vector) {
        std::cout << vec << std::endl;
    }
}

int main() {
    print(reverseArray({1, 2, 3, 4}));
    std::cout << std::endl;
    print(reverseArray({1, 2, 3}));
}

