#include "Stack.h"

template<typename T>
Stack<T>::Stack() : store(new T[ds_utils::STACK_DEFAULT_SIZE]), items(0), allocated(ds_utils::STACK_DEFAULT_SIZE) {}

template<typename T>
std::size_t Stack<T>::size() {
    return items;
}

template<typename T>
bool Stack<T>::isEmpty() {
    return items == 0;
}

template<typename T>
T Stack<T>::pop() {
    if (isEmpty()) {
        throw std::runtime_error("Stack is already empty");
    }
    return store[--items];
}

template<typename T>
void Stack<T>::push(T item) {
    if (items >= allocated) {
        size_t newAllocated = allocated * ds_utils::STACK_DEFAULT_REPLICATION_NUMBER;
        auto newStore = ds_utils::extend_store(allocated, store, newAllocated);
        allocated = newAllocated;
        delete[] store;
        store = newStore;
    }

    store[items++] = item;
}

template<typename T>
ForwardIterator<T> Stack<T>::begin() {
    return ForwardIterator<T>(&store[items]);
}

template<typename T>
ForwardIterator<T> Stack<T>::end() {
    return ForwardIterator<T>(&store[0]);
}

template Stack<int>::Stack();

template void Stack<int>::push(int item);

template int Stack<int>::pop();

template ForwardIterator<int> Stack<int>::begin();

template ForwardIterator<int> Stack<int>::end();