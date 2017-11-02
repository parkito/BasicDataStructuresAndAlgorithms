package com.saiu.dataStructures.simpleLinkedList;

import com.saiu.dataStructures.exceptions.IncorrectIndexException;
import com.saiu.dataStructures.utils.SystemUtils;

import static com.saiu.dataStructures.utils.SystemUtils.checkDataStructureSize;
import static com.saiu.dataStructures.utils.SystemUtils.checkingIndex;

/**
 * Created by Artyom Karnov on 23.11.16.
 * artyom-karnov@yandex.ru
 * <p>
 * Typical linkedList
 *
 * @param <T> object type for storing in linkedList
 */
public class LinkedList<T> {
    /**
     * Class represents list of list
     *
     * @param <T> object type for storing in list
     */
    private static class List<T> {
        private T data;
        private List next;

        public List() {
            next = null;
        }
    }

    private List<T> firstList;
    private int size;

    /**
     * Constructor with begin initialization
     */
    public LinkedList() {
        size = 0;
        firstList = new List<>();
    }

    /**
     * Adding element to linkedList
     *
     * @param element element for adding
     */
    public void add(T element) {
        checkDataStructureSize(size);
        List tempList = firstList;
        while (tempList.next != null) {
            tempList = tempList.next;
        }
        size++;
        tempList.data = element;
        tempList.next = new List();
    }

    /**
     * Getting element from adjusted position
     *
     * @param index index of element in linkedList
     * @return element from adjusted position
     */
    public T get(int index) {
        checkingIndex(index, size);
        List tempList = firstList;
        for (int i = 0; i < index; i++) {
            tempList = tempList.next;
        }
        return (T) tempList.data;
    }

    /**
     * Method for displaying all lists of liked list
     */
    @SuppressWarnings("Warning")
    public <T> T[] toArray() {
        T[] arr = (T[]) new Object[size];
        List tempList = firstList;
        int i = 0;
        while (tempList.next != null) {
            arr[i] = (T) tempList.data;
            tempList = tempList.next;
        }
        return arr;
    }

    /**
     * Removing element with index = 0
     */
    public void removeFirst() {
        if (size() > 0) {
            firstList = firstList.next;
        } else {
            throw new IncorrectIndexException("Index couldn't be less than 0");
        }
    }

    /**
     * Removing element with last index
     */
    public void removeLast() {
        if (size() > 1) {
            List tempList = firstList;
            while (tempList.next.next != null) {
                tempList = tempList.next;
            }
            tempList.next = null;
        } else if (size() == 1)
            removeFirst();
        else {
            throw new IncorrectIndexException("Index couldn't be <0");
        }
    }

    /**
     * Removing element with adjusted index
     *
     * @param index index for removing
     */

      /*
        * There are 3 situations when is needed to remove list from com.saiu.dataStructures.doubleLinkedList
        * 1 - needed element is first - checking by "if"
        * ([X][][][][])
        * 2 - is needed to remove last element - checking by "else if"
        * ([][][][][X])
        * 3 - is needed to remove element which "surrounded" by others - on last "else"
        * ([][][X][][])
     */
    public void remove(int index) {
        checkingIndex(index, size);
        if (index == 0) {
            removeFirst();
        } else if (index == size) {
            removeLast();
        } else {
            List tempList = firstList;
            for (int i = 0; i < index - 1; i++) {
                tempList = tempList.next;
            }
            tempList.next = tempList.next.next;
        }

    }


    /**
     * Checking linkedList on elements presence
     *
     * @return true - if linkedList has elements, false - if linkedList is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Getting size of linkedList
     *
     * @return number of elements in linked list
     */
    public int size() {
        return size;
    }

    /**
     * Checking elements storing in linkedList
     *
     * @param element element for checking
     * @return true - if array contain adjusted element, false - if doesn't
     */
    public boolean contains(T element) {
        List tempList = firstList;
        while (tempList.next != null) {
            if (tempList.data.equals(element)) {
                return true;
            }
            tempList = tempList.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List tempList = firstList;
        while (tempList.next != null) {
            result.append(tempList.data);
            result.append(" ");
            tempList = tempList.next;
        }
        return "LinkedList{" + result.toString() + "}";
    }
}
