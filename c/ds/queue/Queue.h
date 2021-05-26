#pragma once

#include "DsUtils.h"
#include "ForwardIterator.h"

template<typename T>
class QueueNode {
public:
    T item;
    QueueNode *next = nullptr;

    QueueNode(T item, QueueNode *next) : item(item), next(next) {};
};

template<typename T>
class NodeIterator {
public:
    using pointer = T *;  // or also value_type*
    using reference = T &;  // or also value_type&

    explicit NodeIterator(QueueNode<T> *ptr_) : ptr(ptr_) {};

    reference operator*() const {
        return ptr->item;
    }

    pointer operator->() {
        return this;
    }

    //prefix inc
    NodeIterator<T> &operator++() {
        ptr = ptr->next;
        return *this;
    }

    //postfix inc
    NodeIterator<T> &operator++(int) {
        auto tmp = ptr;
        ptr = ptr->next;
        return tmp;
    }

    friend bool operator==(const NodeIterator<T> &a, const NodeIterator<T> &b) { return a.ptr == b.ptr; };

    friend bool operator!=(const NodeIterator<T> &a, const NodeIterator<T> &b) { return a.ptr != b.ptr; };

private:
    QueueNode<T> *ptr;
};

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

    NodeIterator<T> begin();

    NodeIterator<T> end();

private:
    QueueNode<T> *root;
    std::size_t items;
};


