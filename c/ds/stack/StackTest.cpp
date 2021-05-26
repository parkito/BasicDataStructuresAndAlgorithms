#include <iostream>
#include "Stack.h"

int main() {
    auto stack = Stack<int>{};

    stack.push(1);
    stack.push(2);
    stack.push(3);


    for (auto &el:stack) {
        std::cout << el << " ";
    }

    std::cout << std::endl << stack.pop() << " " << stack.pop() << std::endl;

    for (auto &el:stack) {
        std::cout << el << " ";
    }
}
