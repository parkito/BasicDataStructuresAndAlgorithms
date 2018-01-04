package ru.siksmfp.basic.structure.array.fixed;

import ru.siksmfp.basic.structure.utils.StructureUtils;

/**
 * Created by Artyom Karnov on 15.11.16.
 * artyom-karnov@yandex.ru
 * <p>
 * Array of fix length. Non initialized elements - 0
 *
 * @param <T> object type for storing in array
 */
public class FixedArray<T> {
    private final Object[] fixArray;
    private final int maxSize;

    /**
     * Constructor for getting array's size and initialization
     *
     * @param size array size
     */
    public FixedArray(int size) {
        this.maxSize = size;
        StructureUtils.checkDataStructureSize(size);
        fixArray = new Object[size];
    }

    /**
     * Getting element on adjusted index in array
     *
     * @param index index of element
     * @return element on adjusted index
     */
    public T get(int index) {
        StructureUtils.checkingIndex(index, size());
        return (T) fixArray[index];
    }

    /**
     * Addition new element on adjusted index
     *
     * @param element element for adding
     * @param index   index of adding
     */
    public void add(int index, T element) {
        StructureUtils.checkingIndex(index, size());
        fixArray[index] = element;
    }

    /**
     * Removing element on adjusted index
     *
     * @param index element's index in array
     */
    public void remove(int index) {
        StructureUtils.checkingIndex(index, size());
        leftShift(index);
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

    /**
     * Checking element's existing in array
     *
     * @return true if size=0, false if size>0
     */
    public boolean isEmpty() {
        return maxSize == 0;
    }

    /**
     * Array left shifting
     * <p>
     * Consider [1] [2] [3] [4]. We have to shift array since index = 1
     * Then we have [1] [3] [4] [NULL]
     *
     * @param startWithIndex first index for shifting
     */
    private void leftShift(int startWithIndex) {
        for (int i = startWithIndex; i < size() - 1; i++) {
            fixArray[i] = fixArray[i + 1];
        }
        fixArray[size() - 1] = null;
    }
}