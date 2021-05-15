#include "BagIterator.h"

template<typename T>
typename BagIterator<T>::reference BagIterator<T>::operator*() const { return ptr; }

template<typename T>
typename BagIterator<T>::pointer BagIterator<T>::operator->() { return *this; }

template<typename T>
BagIterator<T> &BagIterator<T>::operator++() {
    ptr++;
    return *this;
}

template<typename T>
BagIterator<T> &BagIterator<T>::operator++(int) {
    auto tmp = *this;
    ++(*this);
    return tmp;
}
