#pragma once

#include <iterator>

template<typename T>
class BagIterator {
public:
    using iterator_category = std::forward_iterator_tag;
    using difference_type = std::ptrdiff_t;
    using value_type = T;
    using pointer = T *;  // or also value_type*
    using reference = T &;  // or also value_type&

    BagIterator(pointer ptr_) : ptr(ptr_) {};

    reference operator*() const;

    pointer operator->();

    //prefix inc
    BagIterator<T> &operator++();

    //postfix inc
    BagIterator<T> &operator++(int);

    friend bool operator==(const BagIterator<T> &a, const BagIterator<T> &b);

    friend bool operator!=(const BagIterator<T> &a, const BagIterator<T> &b);

private:
    pointer ptr;
};
