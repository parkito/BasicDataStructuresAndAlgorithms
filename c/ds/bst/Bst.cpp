#include "Bst.h"

template<typename T>
void Bst<T>::add(T item) {
    if (isEmpty()) {
        root = new Node<T>{item};
        items++;
        return;
    }
    items++;
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
                current->left = new Node<T>{item};
                return;
            }
            current = current->left;
        }
    }
}

template<typename T>
void Bst<T>::remove(T item) {
    if (isEmpty()) {
        return;
    }
}

template<typename T>
std::size_t Bst<T>::depth() {
    if (isEmpty()) {
        return 0;
    }

    return recDepth(*root, 0);
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
           current= current->left;
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

template<typename T>
std::size_t Bst<T>::recDepth(const Node<T> &node, std::size_t level) {
    size_t nextLevel = level + 1;
    if (node.left != nullptr && node.right != nullptr) {
        return std::max(recDepth(*node.right, nextLevel), recDepth(*node.left, nextLevel));
    } else if (node.left == nullptr && node.right == nullptr) {
        return level;
    } else if (node.left != nullptr) {
        return recDepth(*node.left, nextLevel);
    } else {
        return recDepth(*node.right, nextLevel);
    }
}

template void Bst<int>::add(int item);

template std::size_t Bst<int>::depth();

template void Bst<int>::remove(int item);

template bool Bst<int>::contains(int item);
