#include <iostream>

struct SinglyLinkedListNode {
    SinglyLinkedListNode(int i) {
        data = i;
    }

    int data;
    SinglyLinkedListNode *next;
};

SinglyLinkedListNode *insertNodeAtPosition(SinglyLinkedListNode *head, int data, int position) {
    auto *newNode = new SinglyLinkedListNode(data);
    if (position == 0) {
        newNode->next = head;
        return newNode;
    }

    SinglyLinkedListNode *current = head;
    for (int i = 0; i < position - 1; ++i) {
        current = current->next;
    }

    if (current->next == nullptr) {
        newNode->next = nullptr;
    } else {
        newNode->next = current->next;
    }
    current->next = newNode;

    return head;
}

int main() {

}
