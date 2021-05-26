#include "Bag.h"

template<typename T>
Bag<T>::Bag() : items{0}, allocated{ds_utils::BAG_DEFAULT_SIZE}, store{new T[ds_utils::BAG_DEFAULT_SIZE]} {}

template<typename T>
bool Bag<T>::isEmpty() {
    return items == 0;
}

template<typename T>
std::size_t Bag<T>::size() {
    return items;
}

template<typename T>
ForwardIterator<T> Bag<T>::begin() {
    return ForwardIterator<T>(&store[0]);
}

template<typename T>
ForwardIterator<T> Bag<T>::end() {
    return ForwardIterator<T>(&store[items]);
}

template<typename T>
void Bag<T>::add(T item) {
    if (items >= allocated) {
        size_t newAllocated = allocated * ds_utils::BAG_DEFAULT_REPLICATION_NUMBER;
        auto newStore = ds_utils::extend_store(allocated, store, newAllocated);
        allocated = newAllocated;
        delete[] store;
        store = newStore;
    }

    store[items++] = item;
}

template Bag<int>::Bag();

template void Bag<int>::add(int item);

template ForwardIterator<int> Bag<int>::begin();

template ForwardIterator<int> Bag<int>::end();

template void Bag<double>::add(double item);

template ForwardIterator<double> Bag<double>::begin();

template ForwardIterator<double> Bag<double>::end();