#include "Bag.h"

template<typename T>
void Bag<T>::extend_store(std::size_t to, T *arrFrom, T *arrTo) {
    for (std::size_t i = 0; i < to; ++i) {
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
    return BagIterator<T>(&store[items]);
}

template<typename T>
void Bag<T>::add(T item) {
    if (items >= allocated) {
        size_t newAllocated = allocated * REP_INC_CONST;
        T *newStore = new T[newAllocated];
        extend_store(allocated, store, newStore);
        allocated = newAllocated;
        delete[] store;
        store = newStore;
    }

    store[items++] = item;
}

template void Bag<int>::add(int item);

template BagIterator<int> Bag<int>::begin();

template BagIterator<int> Bag<int>::end();

template void Bag<double>::add(double item);

template BagIterator<double> Bag<double>::begin();

template BagIterator<double> Bag<double>::end();