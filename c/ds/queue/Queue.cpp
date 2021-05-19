#include "Queue.h"

template<typename T>
void Queue<T>::enqueue(T item) {
    if (items == 0) {
        root = new QueueNode<T>{item, nullptr};
    } else {
        auto node = root;
        while (node->next != nullptr) {
            node = node->next;
        }
        node->next = new QueueNode<T>{item, nullptr};
    }
    items++;
}

template<typename T>
T Queue<T>::dequeue() {
    if (isEmpty()) {
        throw std::runtime_error("Queue is empty");
    }
    auto item = root->item;
    if (size() > 1) {
        auto oldRoot = root;
        root = root->next;
        delete oldRoot;
    } else {
        delete root;
        root = nullptr;
    }
    items--;
    return item;
}

template<typename T>
bool Queue<T>::isEmpty() {
    return items == 0;
}

template<typename T>
std::size_t Queue<T>::size() {
    return items;
}

template<typename T>
NodeIterator<T> Queue<T>::begin() {
    return NodeIterator<T>(root);
}

template<typename T>
NodeIterator<T> Queue<T>::end() {
    return NodeIterator<T>(nullptr);
}

template void Queue<int>::enqueue(int item);

template int Queue<int>::dequeue();

template std::size_t Queue<int>::size();

template NodeIterator<int> Queue<int>::begin();

template NodeIterator<int> Queue<int>::end();
