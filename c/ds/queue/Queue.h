#pragma once

#include "DsUtils.h"
#include "ForwardIterator.h"

template<typename T>
class Queue {
public:
    Queue() : items{0}, allocated{ds_utils::QUEUE_DEFAULT_SIZE},
              store{new T[ds_utils::QUEUE_DEFAULT_REPLICATION_NUMBER]} {}

    ~Queue() {
        delete[] store;
    }

    void enqueue(T item);

    T dequeue();

    bool isEmpty();

    std::size_t size();

    ForwardIterator <T> begin();

    ForwardIterator <T> end();

private:
    T *store;
    std::size_t items;
    std::size_t allocated;

};


