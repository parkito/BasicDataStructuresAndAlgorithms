package ru.siksmfp.basic.structure.list.linked.doubled;


import ru.siksmfp.basic.structure.api.ArrayStructure;
import ru.siksmfp.basic.structure.api.Iterator;
import ru.siksmfp.basic.structure.api.ListStructure;
import ru.siksmfp.basic.structure.exceptions.IncorrectIndexException;
import ru.siksmfp.basic.structure.exceptions.IncorrectSizeException;
import ru.siksmfp.basic.structure.utils.StructureUtils;

/**
 * Created by Artyom Karnov on 26.11.16.
 * artyom-karnov@yandex.ru
 * <p>
 * Typical com.saiu.ru.siksmfp.basic.structure.list.linked.doubled
 *
 * @param <T> object type for storing in com.saiu.ru.siksmfp.basic.structure.list.linked.doubled
 */
public class DoublyLinkedList<T> implements ListStructure<T> {

    private class List<T> {
        public T data;
        public List next;
        public List previous;

        public List() {
            next = null;
        }

        public List(List previous) {
            next = null;
            this.previous = previous;
        }
    }

    private List<T> firstList = new List<>(null);
    private int size;

    /**
     * Constructor with begin initialization
     */
    public DoublyLinkedList() {
        size = 0;
        firstList = new List<>();
    }

    /**
     * Add elements to linked list
     *
     * @param objects objects for adding
     */
    public DoublyLinkedList(T... objects) {
        for (T object : objects) {
            add(object);
        }
    }

    /**
     * Creating simple linked list from array structure
     *
     * @param arrayStructure structure for creating
     */
    public DoublyLinkedList(ArrayStructure<T> arrayStructure) {
        for (int i = 0; i < arrayStructure.size(); i++) {
            add(arrayStructure.get(i));
        }
    }

    /**
     * Adding element to com.saiu.ru.siksmfp.basic.structure.list.linked.doubled
     *
     * @param element element for adding
     */
    public void add(T element) {
        List<T> tempList = firstList;
        while (tempList.next != null) {
            tempList = tempList.next;
        }
        size++;
        tempList.data = element;
        tempList.next = new List(tempList);
    }

    @Override
    public void strictAdd(T element) {

    }

    @Override
    public void replace(int index, T element) {

    }

    @Override
    public void strictReplace(int index, T element) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    /**
     * Get first element of linked list
     *
     * @return first element of linked list
     */
    @Override
    public T getFirst() {
        if (size > 0) {
            return firstList.data;
        } else {
            throw new IncorrectSizeException("List is empty");
        }
    }

    /**
     * Get last element of linked list
     *
     * @return last element of linked list
     */
    @Override
    public T getLast() {
        if (size() > 1) {
            List<T> tempDoublyList = firstList;
            while (tempDoublyList.next.next != null) {
                tempDoublyList = tempDoublyList.next;
            }
            return tempDoublyList.data;
        } else if (size == 1)
            return getFirst();
        else {
            throw new IncorrectIndexException("List is empty");
        }
    }

    /**
     * Displaying com.saiu.ru.siksmfp.basic.structure.list.linked.doubled from last index
     */
    public void displayFromEnd() {
        List<T> tempList = firstList;
        while (tempList.next != null) {
            tempList = tempList.next;
        }
        tempList = tempList.previous;//?
        while (tempList != null) {
            System.out.println(tempList.data);
            tempList = tempList.previous;
        }
    }

    /**
     * Removing element with index = 0
     */
    public void removeFirst() {
        if (size() > 0) {
            firstList = firstList.next;
            size--;
        } else {
            throw new IncorrectIndexException("Index couldn't be <0");
        }
    }

    /**
     * Removing element with last index
     */
    public void removeLast() {
        if (size() > 1) {
            List<T> tempList = firstList;
            while (tempList.next.next != null) {
                tempList = tempList.next;
            }
            tempList.next = null;
            size--;
        } else if (size() == 1)
            removeFirst();
        else {
            throw new IncorrectIndexException("Index couldn't be <0");
        }
    }

    /**
     * Replace element with @index on NULL value
     *
     * @param index index of replacement element
     */
    @Override
    public void delete(int index) {
        StructureUtils.checkingIndex(index, size);
        List<T> tempList = firstList;
        for (int i = 0; i < index; i++) {
            tempList = tempList.next;
        }
        tempList.data = null;
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
            List<T> tempList = firstList;
            for (int i = 0; i < index - 1; i++) {
                tempList = tempList.next;
            }
            size--;
            tempList.next = tempList.next.next;
        }
    }

    /**
     * Method for displaying all lists of liked list
     */
    @SuppressWarnings("Warning")
    @Override
    public T[] toArray() {
        Object[] arr = new Object[size];
        List<T> tempList = firstList;
        int i = 0;
        while (tempList.next != null) {
            arr[i] = tempList.data;
            tempList = tempList.next;
        }
        return (T[]) arr;
    }

    /**
     * Checking linkedList on elements presence
     *
     * @return true - if linkedList has elements, false - if linkedList is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> getIterator() {
        return null;
    }

    /**
     * Getting size of linkedList
     *
     * @return number of elements
     */
    public int size() {
        int i = 0;
        List<T> tempList = firstList;
        while (tempList.next != null) {
            i++;
            tempList = tempList.next;
        }
        return i;
    }

    /**
     * Checking elements storing in linkedList
     *
     * @param element element for checking
     * @return true - if array contain adjusted element, false - if doesn't
     */
    public boolean contains(T element) {
        List<T> tempList = firstList;
        while (tempList.next != null) {
            if (tempList.data.equals(element)) {
                return true;
            }
            tempList = tempList.next;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedList<T> list1 = (DoublyLinkedList<T>) o;
        if (size != list1.size) return false;

        List<T> tempList = firstList;
        List<T> tempList1 = list1.firstList;
        while (tempList.next != null) {
            if (tempList.data == null || tempList1.data == null) {
                if (tempList.data == null && tempList1.data != null)
                    return false;
                if (tempList.data != null && tempList1.data == null)
                    return false;
            } else {
                if (!tempList.data.equals(tempList1.data))
                    return false;
            }
            tempList = tempList.next;
            tempList1 = tempList1.next;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * size;
        for (int i = 0; i < size; i++) {
            if (firstList != null) {
                List<T> tempList = firstList;
                while (tempList.next != null) {
                    result += 31 * tempList.data.hashCode();
                    tempList = tempList.next;
                }
            } else {
                result += 31;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<T> tempList = firstList;
        while (tempList.next != null) {
            result.append(tempList.data);
            result.append(", ");
            tempList = tempList.next;
        }
        if (result.length() > 1) {
            result.delete(result.length() - 2, result.length());
        }
        return "DoublyLinkedList{" + result.toString() + "}";
    }
}