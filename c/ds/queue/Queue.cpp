#include "Queue.h"

template<typename T>
void Queue<T>::enqueue(T item) {
    if (items >= allocated) {
        size_t newAllocated = allocated * ds_utils::QUEUE_DEFAULT_REPLICATION_NUMBER;
        auto newStore = ds_utils::extend_store(allocated, store, newAllocated);
        allocated = newAllocated;
        delete[] store;
        store = newStore;
    }

    store[items++] = item; //to do fix
}

template<typename T>
T Queue<T>::dequeue() {
    if (isEmpty()) {
        throw std::runtime_error("Queue is empty");
    }
    return store[--items];
}

template<typename T>
bool Queue<T>::isEmpty() {
    return items == 0;
}

template<typename T>
std::size_t Queue<T>::size() {
    return items;
}

template<typename T>
ForwardIterator<T> Queue<T>::begin() {
    return ForwardIterator<T>(&store[0]);
}

template<typename T>
ForwardIterator<T> Queue<T>::end() {
    return ForwardIterator<T>(&store[items]);
}

template void Queue<int>::enqueue(int item);

template int Queue<int>::dequeue();

template std::size_t Queue<int>::size();

template ForwardIterator<int> Queue<int>::begin();

template ForwardIterator<int> Queue<int>::end();
