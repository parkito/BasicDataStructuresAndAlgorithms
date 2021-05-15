#include "Bag.h"
#include <iostream>

int main() {
    auto bag = Bag<int>{};
    bag.add(1);
    bag.add(2);
    bag.add(3);
    bag.add(4);

    for (auto a:bag) {
        std::cout << a<<" ";
    }
}

