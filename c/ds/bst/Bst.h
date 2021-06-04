#pragma once

#include <cstddef>
#include <vector>
#include <optional>

template<typename T>
class Node {
public:
    explicit Node(T value) : value(value), left(nullptr), right(nullptr) {}

    ~Node() {
        delete left;
        delete right;
    }

    T value;
    Node<T> *left;
    Node<T> *right;
};

template<typename T>
using NodeLevels = std::vector<std::vector<Node<T> *>>;

template<typename T>
using NodeLevel = std::vector<Node<T> *>;

template<typename T>
class Bst {
public:

    Bst() : items{0}, root{nullptr} {}

    ~Bst() {
        delete root;
    }

    void add(T item);

    void remove(T item);

    std::size_t depth();

    std::size_t size();

    bool isEmpty();

    bool contains(T item);

    std::vector<T> toVector();

    void print();

    std::vector<std::string> toLines();


private:
    std::size_t items;

    Node<T> *root;


    void addChildren(const NodeLevel<T> &parentLevel, NodeLevels<T> &allLevels, size_t depth);

    void addToVec(const Node<T> &node, std::vector<T> &vector);

    std::size_t recDepth(const Node<T> &node, std::size_t level);
};

