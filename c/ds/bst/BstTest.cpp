#include <iostream>
#include "Bst.h"

int main() {
    auto bst = Bst<int>{};

    bst.add(10);
    bst.add(5);
    bst.add(15);
    bst.add(13);
    bst.add(16);

    std::cout << bst.depth() << std::endl;
    std::cout << bst.contains(3) << std::endl;
    std::cout << bst.contains(5) << std::endl;

    for (const auto &item : bst.toLines()) {
        std::cout << item << std::endl;
    }
}
