#include "Bag.h"
#include <iostream>

int main() {
    auto intBag = Bag<int>{};
    intBag.add(1);
    intBag.add(2);
    intBag.add(3);
    intBag.add(4);

    for (auto a:intBag) {
        std::cout << a << " ";
    }

    std::cout << std::endl;

    auto doubleBag = Bag<double>{};
    doubleBag.add(2.2);

    for (auto a:doubleBag) {
        std::cout << a << " ";
    }
}

