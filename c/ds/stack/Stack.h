#pragma once

#include <cstddef>
#include "DsUtils.h"
#include "ForwardIterator.h"

template<typename T>
class ForwardStackIterator {
public:
    using iterator_category = std::forward_iterator_tag;
    using difference_type = std::ptrdiff_t;
    using value_type = T;
    using pointer = T *;  // or also value_type*
    using reference = T &;  // or also value_type&

    explicit ForwardStackIterator(pointer ptr_) : ptr(ptr_) {};

    reference operator*() const {
        return *ptr;
    }

    pointer operator->() {
        return this;
    }

    //prefix inc
    ForwardStackIterator<T> &operator++() {
        ptr--;
        return *this;
    }

    //postfix inc
    ForwardStackIterator<T> &operator++(int) {
        auto tmp = *this;
        --(*this);
        return tmp;
    }

    friend bool operator==(const ForwardStackIterator<T> &a, const ForwardStackIterator<T> &b) {
        return a.ptr == b.ptr;
    };

    friend bool operator!=(const ForwardStackIterator<T> &a, const ForwardStackIterator<T> &b) {
        return a.ptr != b.ptr;
    };

private:
    pointer ptr;
};

template<typename T>
class Stack {
public:
    Stack();

    ~Stack() {
        delete[] store;
    }

    void push(T item);

    T pop();

    bool isEmpty();

    std::size_t size();

    ForwardStackIterator<T> begin();

    ForwardStackIterator<T> end();

private:
    T *store;
    std::size_t items;
    std::size_t allocated;
};
