#pragma once

#include "DsUtils.h"
#include "ForwardIterator.h"

template<typename T>
class Queue {
public:
    Queue() : items{0},
              root{nullptr} {}

    ~Queue() {
        delete root;
    }

    void enqueue(T item);

    T dequeue();

    bool isEmpty();

    std::size_t size();

    ForwardIterator<T> begin();

    ForwardIterator<T> end();

private:
    struct QueueNode {
        T item;
        QueueNode *next = nullptr;

        QueueNode(T item, Queue::QueueNode *next) : item(item), next(next) {};
    };

    QueueNode *root;
    std::size_t items;
};


