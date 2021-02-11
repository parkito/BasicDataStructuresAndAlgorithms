#pragma once

#include <iostream>
#include <vector>

namespace global {
    template<typename T>
    void print(const std::vector<T> &vector) {
        for (auto &vec :vector) {
            std::cout << vec << std::endl;
        }
        std::cout << std::endl;
    }

    template<typename T>
    void swap(T &a, T &b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
