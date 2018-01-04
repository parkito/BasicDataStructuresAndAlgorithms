package ru.siksmfp.basic.structure.array.dynamic;

import ru.siksmfp.basic.structure.utils.StructureUtils;
import ru.siksmfp.basic.structure.utils.SystemUtils;

/**
 * Created by Artyom Karnov on 17.11.16.
 * artyom-karnov@yandex.ru
 * <p>
 * Array of variable length. Non initialized elements - 0
 *
 * @param <T> object type for storing in array
 */
public class Array<T> {
    private Object[] array;
    private int size;

    /**
     * Constructor without parameters
     */
    public Array() {
        array = new Object[0];
        size=0;
    }

    /**
     * Creating Array by copying other array in constructor
     *
     * @param arrayForCopy array for copy
     */
    public Array(Array<T> arrayForCopy) {
        size = arrayForCopy.size();
        array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = SystemUtils.clone(arrayForCopy.get(i));
        }
    }

    /**
     * Constructor for getting array's size and initialization
     *
     * @param size array size
     */
    public Array(int size) {
        StructureUtils.checkDataStructureSize(size);
        this.size = size;
        array = new Object[size * 2];
    }

    /**
     * Add element on given index
     *
     * @param element element for adding
     * @param index   index of adding element
     */
    public void add(int index, T element) {
        StructureUtils.checkingIndex(index, size);
        array[index] = element;
    }

    /**
     * Add element on given position by deep copying of element
     *
     * @param element element for adding
     * @param index   position of adding element
     */
    public void strictAdd(int index, T element) {
        StructureUtils.checkingIndex(index, size);
        array[index] = SystemUtils.clone(element);
    }

    public void add(T element) {
        Object[] extendedArray = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            extendedArray[i] = array[i];
        }
        extendedArray[size] = element;
        array = extendedArray;
        size++;
    }

    public void strictAdd(T element) {
        Object[] extendedArray = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            extendedArray[i] = SystemUtils.clone(array[i]);
        }
        extendedArray[size] = SystemUtils.clone(element);
        array = extendedArray;
        size++;
    }

    /**
     * Getting element on adjusted index in array
     *
     * @param index index of element
     * @return element on adjusted index
     */
    public T get(int index) {
        StructureUtils.checkingIndex(index, size);
        return (T) array[index];
    }

    /**
     * Removing element on adjusted index
     *
     * @param index element's index in array
     */
    public void remove(int index) {
        StructureUtils.checkingIndex(index, size());
        leftShift(index);
        size--;
    }

    /**
     * Strict removing element on given index
     * There is deep copying during element's offset
     *
     * @param index index of removing element
     */
    public void strictRemove(int index) {
        StructureUtils.checkingIndex(index, size());
        strictLeftShift(index);
        size--;
    }

    /**
     * Deleting element on given index form array
     * NULL-value is being set instead element on given index
     *
     * @param index index of deleting element
     */
    public void delete(int index) {
        StructureUtils.checkingIndex(index, size());
        array[index] = null;
    }

    /**
     * Getting array size
     *
     * @return size of array
     */
    public int size() {
        return size;
    }

    /**
     * Checking elements storing in array
     *
     * @param element element for checking
     * @return true - if array contain adjusted element, false - if doesn't
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element))
                return true;
        }
        return false;
    }

    /**
     * Checking element's existing in array
     *
     * @return true if size=0, false if size>0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method for decreasing array after deleting element
     *
     * @param position position of deleting element
     * @return array without adjusted element
     */
    private Object[] offset(int position) {
        Object offsetArray[] = new Object[size - 1];
        for (int i = 0; i < size - 1; i++) {
            if (i >= position) {
                offsetArray[i] = array[i + 1];
                array[i] = null;
            } else {
                offsetArray[i] = array[i];
            }
        }
        return offsetArray;
    }

    /**
     * Method for strict decreasing array after deleting element
     * There is deep element's copying during offset
     *
     * @param position position of deleting element
     * @return array without adjusted element
     */
    private Object[] strictOffset(int position) {
        Object offsetArray[] = new Object[size - 1];
        for (int i = 0; i < size - 1; i++) {
            if (i >= position) {
                offsetArray[i] = SystemUtils.clone(array[i + 1]);
                array[i] = null;
            } else {
                offsetArray[i] = SystemUtils.clone(array[i]);
            }
        }
        return offsetArray;
    }

    private void leftShift(int startWithIndex) {
        for (int i = startWithIndex; i < size() - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size() - 1] = null;
    }

    private void strictLeftShift(int startWithIndex) {
        for (int i = startWithIndex; i < size() - 1; i++) {
            array[i] = SystemUtils.clone(array[i + 1]);
        }
        array[size() - 1] = null;
    }
}