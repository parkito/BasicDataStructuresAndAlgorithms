#pragma once

#include <iterator>

template<typename T>
class ForwardIterator {
public:
    using iterator_category = std::forward_iterator_tag;
    using difference_type = std::ptrdiff_t;
    using value_type = T;
    using pointer = T *;  // or also value_type*
    using reference = T &;  // or also value_type&

    explicit ForwardIterator(pointer ptr_) : ptr(ptr_) {};

    reference operator*() const {
        return *ptr;
    }

    pointer operator->() {
        return this;
    }

    //prefix inc
    ForwardIterator<T> &operator++() {
        ptr++;
        return *this;
    }

    //postfix inc
    ForwardIterator<T> &operator++(int) {
        auto tmp = *this;
        ++(*this);
        return tmp;
    }

    friend bool operator==(const ForwardIterator<T> &a, const ForwardIterator<T> &b) { return a.ptr == b.ptr; };

    friend bool operator!=(const ForwardIterator<T> &a, const ForwardIterator<T> &b) { return a.ptr != b.ptr; };

private:
    pointer ptr;
};
