#pragma once

#include <array>
#include "BagIterator.h"

template<typename T>
class Bag {
public:
    Bag();

    ~Bag();

    void add(T &item);

    bool isEmpty();

    std::size_t size();

    BagIterator<T> begin();

    BagIterator<T> end();

private:
    T *store;
    std::size_t items;
    std::size_t allocated;

    static const std::size_t REP_CONST = 10;
    static const std::size_t REP_INC_CONST = 2;

    void extend_store(std::size_t from, std::size_t to, T *arrFrom, T *arrTo);
};
