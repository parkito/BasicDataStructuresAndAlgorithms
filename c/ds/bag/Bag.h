#pragma once

#include "DsUtils.h"
#include "ForwardIterator.h"

template<typename T>
class Bag {
public:
    Bag() : items{0}, allocated{ds_utils::BAG_DEFAULT_SIZE}, store{new T[ds_utils::BAG_DEFAULT_SIZE]} {}

    ~Bag() {
        delete[] store;
    }

    void add(T item);

    bool isEmpty();

    std::size_t size();

    ForwardIterator<T> begin();

    ForwardIterator<T> end();

private:
    T *store;
    std::size_t items;
    std::size_t allocated;
};
