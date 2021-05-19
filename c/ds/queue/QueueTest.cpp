#include <iostream>
#include "Queue.h"

int main() {
    auto qu = Queue<int>();
    qu.enqueue(1);
    qu.enqueue(2);
    qu.enqueue(3);

    for (auto q:qu) {
        std::cout << q << " ";
    }
    std::cout << std::endl;
    std::cout << qu.size() << std::endl;//3
    std::cout << qu.dequeue() << std::endl;//1
    std::cout << qu.dequeue() << std::endl;//2
    std::cout << qu.dequeue() << std::endl;//3
//    std::cout << qu.dequeue() << std::endl;//exception

}

