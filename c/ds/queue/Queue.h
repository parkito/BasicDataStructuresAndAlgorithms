#pragma once

#include <array>

template<typename T>
class Queue {
public:

    ~Queue() {

    }

    void enqueue(T item);

    T dequeue();

    bool isEmpty();

    std::size_t size();


};
