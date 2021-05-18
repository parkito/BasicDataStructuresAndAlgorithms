#include <iostream>
#include "Queue.h"

int main() {
    auto qu = Queue<int>();
    qu.enqueue(1);
    qu.enqueue(2);
    qu.enqueue(3);

    std::cout << qu.size();//3
    std::cout << qu.dequeue();//1
    std::cout << qu.dequeue();//2
    std::cout << qu.dequeue();//3
    std::cout << qu.dequeue();//exception

}

