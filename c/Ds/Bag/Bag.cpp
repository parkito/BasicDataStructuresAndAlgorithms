#include "Bag.h"

template<typename T>
Bag<T>::Bag() {
    items = 0;
    allocated = REP_CONST;
    store = new T[REP_CONST];
}

template<typename T>
Bag<T>::~Bag() {
    delete store;
}

template<typename T>
void Bag<T>::add(T &item) {
    if (items >= allocated) {
        size_t newAllocated = allocated * REP_INC_CONST;
        T *newStore = new T[newAllocated];
        extend_store(0, allocated, store, newStore);
        allocated = newAllocated;
        delete store;
        store = newStore;
    }

    store[items++] = item;
}

template<typename T>
void Bag<T>::extend_store(std::size_t from, std::size_t to, T *arrFrom, T *arrTo) {
    for (std::size_t i = from; i < to; ++i) {
        arrTo[i] = arrFrom[i];
    }
}

template<typename T>
bool Bag<T>::isEmpty() {
    return items == 0;
}

template<typename T>
std::size_t Bag<T>::size() {
    return items;
}

template<typename T>
BagIterator<T> Bag<T>::begin() {
    return BagIterator<T>(&store[0]);
}

template<typename T>
BagIterator<T> Bag<T>::end() {
    return BagIterator<T>(&store[allocated + 1]);
}

