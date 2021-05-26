#pragma once

#include <cstddef>
#include "DsUtils.h"
#include "ForwardIterator.h"

template<typename T>
class Stack {
public:
    Stack();

    void push(T item);

    T pop();

    bool isEmpty();

    std::size_t size();

    ForwardIterator<T> begin();

    ForwardIterator<T> end();

private:
    T *store;
    std::size_t items;
    std::size_t allocated;
};