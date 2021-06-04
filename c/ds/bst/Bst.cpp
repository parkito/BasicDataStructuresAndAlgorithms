#include <string>
#include <optional>
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
            current = current->left;
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

template<typename T>
void Bst<T>::addChildren(const NodeLevel<T> &parentLevel, NodeLevels<T> &allLevels, const std::size_t depth) {
    if (allLevels.size() > depth) {
        return;
    }
    NodeLevel<T> childrenLevel{};
    for (const Node<int> *item : parentLevel) {
        if (item == nullptr) {
            childrenLevel.push_back(nullptr);
            childrenLevel.push_back(nullptr);
        } else {
            childrenLevel.push_back(item->left);
            childrenLevel.push_back(item->right);
        }
    }
    allLevels.push_back(childrenLevel);
    addChildren(childrenLevel, allLevels, depth);
}

template<typename T>
std::vector<std::string> Bst<T>::toLines() {
    NodeLevels<T> allLevels{};
    NodeLevel<T> nv{};
    nv.push_back(root);
    allLevels.push_back(nv);
    addChildren(nv, allLevels, depth());
    std::vector<std::string> lines{allLevels.size()};
    for (const NodeLevel<T> &level : allLevels) {
        std::string line;
        for (const Node<T> *node : level) {
            if (node != nullptr) {
                line += std::to_string(node->value);
            } else {
                line += "NULL";
            }
            line += "  ";
        }
        lines.push_back(line);
    }
    return lines;
}


template void Bst<int>::add(int item);

template std::size_t Bst<int>::depth();

template void Bst<int>::remove(int item);

template bool Bst<int>::contains(int item);

template std::vector<std::string> Bst<int>::toLines();

