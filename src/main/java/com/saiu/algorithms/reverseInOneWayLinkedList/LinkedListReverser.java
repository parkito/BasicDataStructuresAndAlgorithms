package com.saiu.algorithms.reverseInOneWayLinkedList;

import com.saiu.dataStructures.simpleLinkedList.LinkedList;

/**
 * @author Artem Karnov @date 25.02.17.
 * artem.karnov@t-systems.com
 */

/**
 * Reversal one-way linked list
 * listUnpacking and listPacking are needed for transformation
 * LinkedList structure into internal list.
 * Without it algorithm doesn't matter as method for self education
 */

// TODO: 25.02.17 I hate my code. Change it!
public class LinkedListReverser<T> {

    private int linkedListSize;

    public LinkedList<T> reverse(LinkedList<T> sourceList) {
        List currentListRoot = listUnpacking(sourceList),
                resultRoot = null,
                previous = null,
                newList = new List(),
                selfList = currentListRoot;
        boolean resultRootInitializeMark = true;

        while (selfList.next != null) {
            while (selfList.next != null) {
                previous = selfList;
                selfList = selfList.next;
            }
            previous.next = null;
            newList.data = previous.data;
            if (resultRootInitializeMark) {
                resultRoot = newList;
                resultRootInitializeMark = false;
            }
            if (currentListRoot.next != null) {
                newList.next = new List();
            }
            newList = newList.next;
            selfList = currentListRoot;
        }
        sourceList = listPacking(resultRoot);
        return sourceList;
    }

    /**
     * Transformation linked list data structure into list-based structure
     * Needed for algorithm purposes
     *
     * @param linkedList linked list data structure
     * @return list-based structure
     */
    private List<T> listUnpacking(LinkedList<T> linkedList) {
        List<T> sefList = new List<>();
        List<T> root = new List<>();
        root = sefList;
        linkedListSize = linkedList.size();
        for (int i = 0; i < linkedListSize; i++) {
            sefList.data = linkedList.get(i);
            List<T> nextList = new List<>();
            sefList.next = nextList;
            sefList = sefList.next;
        }
        return root;
    }

    /**
     * Transformation list-based structure into linked list structure
     * Needed for test purposes
     *
     * @param selfList first list of structure
     * @return linked list data structure
     */
    private LinkedList<T> listPacking(List<T> selfList) {
        LinkedList<T> linkedList = new LinkedList<T>();
        for (int i = 0; selfList != null; i++) {
            linkedList.add(selfList.data);
            selfList = selfList.next;
        }
        return linkedList;
    }

    private class List<T> {
        public T data;
        public List next;

        public List() {
            next = null;
        }
    }


}
