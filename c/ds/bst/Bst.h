#pragma once

#include <cstddef>
#include <vector>

template<typename T>
class Node {
public:
    Node(T value) : value(value), left(nullptr), right(nullptr) {}

    ~Node() {
        delete left;
        delete right;
    }

    T value;
    Node<T> *left;
    Node<T> *right;
};

template<typename T>
class Bst {
public:

    Bst() : items{0}, root{nullptr} {}

    ~Bst() {
        delete root;
    }

    void add(T item);

    void remove(T item);

    std::size_t size();

    bool contains(T item);

    std::vector<T> toVector();

    void print();

private:
    std::size_t items;

    Node<T> *root;
};

