package ru.siksmfp.basic.structure.list.linked.simple;

import ru.siksmfp.basic.structure.api.ListStructure;
import ru.siksmfp.basic.structure.exceptions.IncorrectIndexException;
import ru.siksmfp.basic.structure.exceptions.IncorrectSizeException;
import ru.siksmfp.basic.structure.utils.StructureUtils;

/**
 * Created by Artyom Karnov on 23.11.16.
 * artyom-karnov@yandex.ru
 * <p>
 * Typical linkedList
 *
 * @param <T> object type for storing in linkedList
 */
public class SimpleLinkedList<T> implements ListStructure<T> {
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
    public SimpleLinkedList() {
        size = 0;
        firstList = new List<>();
    }

    /**
     * Adding element to linkedList
     *
     * @param element element for adding
     */
    @Override
    public void add(T element) {
        StructureUtils.checkDataStructureSize(size);
        List tempList = firstList;
        while (tempList.next != null) {
            tempList = tempList.next;
        }
        size++;
        tempList.data = element;
        tempList.next = new List();
    }


    @Override
    public void strictAdd(Object element) {

    }

    @Override
    public void replace(int index, Object element) {

    }

    @Override
    public void strictReplace(int index, Object element) {

    }

    /**
     * Getting element from adjusted position
     *
     * @param index index of element in linkedList
     * @return element from adjusted position
     */
    public T get(int index) {
        StructureUtils.checkingIndex(index, size);
        List tempList = firstList;
        for (int i = 0; i < index; i++) {
            tempList = tempList.next;
        }
        return (T) tempList.data;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    /**
     * Method for displaying all lists of liked list
     */
    @SuppressWarnings("Warning")
    public T[] toArray() {
        Object[] arr = new Object[size];
        List tempList = firstList;
        int i = 0;
        while (tempList.next != null) {
            arr[i] = tempList.data;
            tempList = tempList.next;
        }
        return (T[]) arr;
    }

    /**
     * Removing element with index = 0
     */
    public void removeFirst() {
        if (size() > 0) {
            firstList = firstList.next;
            size--;
        } else {
            throw new IncorrectSizeException("List is already empty");
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
            size--;
        } else if (size == 1)
            removeFirst();
        else {
            throw new IncorrectIndexException("List is already empty");
        }
    }

    /**
     * Removing element with adjusted index
     *
     * @param index index for removing
     */

    /*
     * There are 3 situations when is needed to remove list from com.saiu.ru.siksmfp.basic.structure.list.linked.doubled
     * 1 - needed element is first - checking by "if"
     * ([X][][][][])
     * 2 - is needed to remove last element - checking by "else if"
     * ([][][][][X])
     * 3 - is needed to remove element which "surrounded" by others - on last "else"
     * ([][][X][][])
     */
    public void remove(int index) {
        StructureUtils.checkingIndex(index, size);
        if (index == 0) {
            removeFirst();
        } else {
            List tempList = firstList;
            for (int i = 0; i < index - 1; i++) {
                tempList = tempList.next;
            }
            size--;
            tempList.next = tempList.next.next;
        }
    }

    @Override
    public void strictRemove(int index) {

    }

    @Override
    public void delete(int index) {

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
    @Override
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
            result.append(", ");
            tempList = tempList.next;
        }
        //remove last ', '
        result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 2);
        return "SimpleLinkedList{" + result.toString() + "}";
    }
}
