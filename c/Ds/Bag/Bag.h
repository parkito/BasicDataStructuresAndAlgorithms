#pragma once

#include <array>
#include "BagIterator.h"

template<typename T>
class Bag {
public:
    ~Bag();

    void add(T item);

    bool isEmpty();

    std::size_t size();

    BagIterator<T> begin();

    BagIterator<T> end();
};