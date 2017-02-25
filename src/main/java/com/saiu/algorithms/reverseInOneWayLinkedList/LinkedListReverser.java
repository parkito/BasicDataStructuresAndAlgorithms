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
public class LinkedListReverser<T> {

    private int linkedListSize;

    public LinkedList<T> reverse(LinkedList<T> sourceList) {
        List selfList = listUnpacking(sourceList);
        //todo algorithm
//        System.out.println(selfList);
        boolean flag = false;
        List root = null, previous = null;
        while (selfList.next != null) {
            previous = selfList;
            selfList = selfList.next;
        }
        if (flag = false) {
            root = selfList;
            previous.next = null;
            root.next = previous;
            root = root.next;
            flag = true;
        } else {
            root.next = selfList;
            root = root.next;
        }

        sourceList = listPacking(root);
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
        linkedListSize = linkedList.size();
        for (int i = 0; i < linkedListSize; i++) {
            sefList.data = linkedList.get(i);
            List<T> nextList = new List<>();
            sefList.next = nextList;
            sefList = sefList.next;
        }
        return sefList;
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
        for (int i = 0; i < linkedListSize; i++) {
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
