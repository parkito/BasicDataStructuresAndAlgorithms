#include "Bst.h"

template<typename T>
void Bst<T>::add(T item) {
    if (isEmpty()) {
        root = new Node<T>(item);
        return;
    }
    auto current = root;
    while (true) {
        if (item >= current->value) {
            auto right = current->right;
            if (right == nullptr) {
                current->right = new Node<T>(item);
                return;
            }
            current = right;
        } else if (item < current->value) {
            auto left = current->left;
            if (left == nullptr) {
                current->left = new Node<T>(item);
                return;
            }
            current = current->left;
        }
        items++;
    }
}

template<typename T>
void Bst<T>::remove(T item) {
    if (isEmpty()) {
        return;
    }
}

template<typename T>
std::size_t Bst<T>::size() {
    return items;
}

template<typename T>
bool Bst<T>::isEmpty() {
    return items == 0;
}

template<typename T>
bool Bst<T>::contains(T item) {
    if (isEmpty()) {
        return false;
    }
    auto current = root;
    while (true) {
        if (current == nullptr) {
            return false;
        } else if (item == current->value) {
            return true;
        } else if (item > current->value) {
            current = current->right;
        } else {
            current->left;
        }
    }
}

template<typename T>
std::vector<T> Bst<T>::toVector() {
    std::vector<T> res{};
    if (isEmpty()) {
        return res;
    }
    return std::vector<T>();
}

template<typename T>
void Bst<T>::addToVec(const Node<T> &node, std::vector<T> &vector) {
    vector.push_back(node.value);
    if (node.left != nullptr) {
        addToVec(node.left, vector);
    }
    if (node.right != nullptr) {
        addToVec(node.right, vector);
    }
}
