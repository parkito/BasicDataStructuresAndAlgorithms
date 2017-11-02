package com.saiu.dataStructures.fixedArray;

import com.saiu.dataStructures.exceptions.IncorrectSizeException;
import com.saiu.dataStructures.exceptions.IncorrectIndexException;

/**
 * Created by Artyom Karnov on 15.11.16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Array of fix length. Non initialized elements - 0
 *
 * @param <T> object type for storing in array
 */
public class FixedArray<T> {
    Object[] fixArray;
    private int maxSize;

    /**
     * Constructor for getting array's size and initialization
     *
     * @param size array size
     */
    public FixedArray(int size) {
        this.maxSize = size;
        if (size <= 0) {
            throw new IncorrectSizeException("Size couldn't be <=0");
        } else if (size < Integer.MAX_VALUE) {
            fixArray = new Object[size];
            arrayInitialization();
        } else {
            throw new IncorrectSizeException("Array overflow");
        }
    }

    /**
     * Method for initialization array before work
     */
    private void arrayInitialization() {
        for (int i = 0; i < maxSize; i++) {
            fixArray[i] = Integer.valueOf(0);
        }
    }

    /**
     * Getting element on adjusted position in array
     *
     * @param position position of element
     * @return element on adjusted position
     */
    public T get(int position) {
        if (position < 0) {
            throw new IncorrectIndexException("Index couldn't be <0");
        } else if (position < maxSize) {
            return (T) fixArray[position];
        } else {
            throw new IncorrectSizeException("Index overflow");
        }
    }

    /**
     * Addition new element on adjusted position
     *
     * @param element  element for adding
     * @param position position of adding
     */
    public void add(int position, T element) {
        if (position < 0) {
            throw new IncorrectIndexException("Index couldn't be <0");
        } else if (position < maxSize) {
            fixArray[position] = element;
        } else {
            throw new IncorrectIndexException("Mistaken index");
        }
    }

    /**
     * Removing element on adjusted position
     *
     * @param position element's position in array
     */
    public void remove(int position) {
        if (position < 0) {
            throw new IncorrectIndexException("Index couldn't be <0");
        } else if (position < maxSize) {
            fixArray[position] = Integer.valueOf(0);
        } else {
            throw new IncorrectIndexException("Incorrect size");
        }
    }

    /**
     * Getting array size
     *
     * @return size of array
     */
    public int size() {
        return maxSize;
    }

    /**
     * Checking elements storing in array
     *
     * @param element element for checking
     * @return true - if array contain adjusted element, false - if doesn't
     */
    public boolean contains(T element) {
        for (int i = 0; i < maxSize; i++) {
            if (fixArray[i].equals(element))
                return true;
        }
        return false;
    }
}