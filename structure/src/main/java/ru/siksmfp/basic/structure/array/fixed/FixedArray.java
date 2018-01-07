package ru.siksmfp.basic.structure.array.fixed;

import ru.siksmfp.basic.structure.api.ArrayStructure;
import ru.siksmfp.basic.structure.exceptions.IncorrectSizeException;
import ru.siksmfp.basic.structure.utils.StructureUtils;
import ru.siksmfp.basic.structure.utils.SystemUtils;

/**
 * Created by Artyom Karnov on 15.11.16.
 * artyom-karnov@yandex.ru
 * <p>
 * Array of fix length. Non initialized elements - 0
 *
 * @param <T> object type for storing in array
 */
public class FixedArray<T> implements ArrayStructure<T> {
    private final Object[] fixedArray;
    private final int maxSize;

    /**
     * Constructor for getting array's size and initialization
     *
     * @param size array size
     */
    public FixedArray(int size) {
        this.maxSize = size;
        StructureUtils.checkDataStructureSize(size);
        fixedArray = new Object[size];
    }

    /**
     * Getting element on adjusted index in array
     *
     * @param index index of element
     * @return element on adjusted index
     */
    public T get(int index) {
        StructureUtils.checkingIndex(index, size());
        return (T) fixedArray[index];
    }

    /**
     * Addition new element on specified index
     *
     * @param element element for adding
     * @param index   index of adding
     */
    public void add(int index, T element) {
        StructureUtils.checkingIndex(index, size());
        fixedArray[index] = element;
    }

    /**
     * Add element on first vacant place from beginning
     * (using deep cloning during array shifting)
     * <p>
     * If no vacant place @throws IncorrectSizeException
     * Example [1] [2] [] [] []
     * Result [1] [2] [NEW] [] []
     *
     * @param element element for adding
     */
    @Override
    public void add(T element) {
        for (int i = 0; i < size(); i++) {
            if (fixedArray[i] == null) {
                fixedArray[i] = element;
                return;
            }
        }
        throw new IncorrectSizeException("There is no vacant place for new element");
    }

    /**
     * Addition new element on specified index strictly
     * (using deep cloning during addition)
     *
     * @param index   index for adding
     * @param element element for adding
     */
    @Override
    public void strictAdd(int index, T element) {
        StructureUtils.checkingIndex(index, size());
        fixedArray[index] = SystemUtils.clone(element);
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
     * Add element on first vacant place from beginning strictly
     * (using deep cloning during array shifting)
     * <p>
     * If no vacant place @throws IncorrectSizeException
     * Example [1] [2] [] [] []
     * Result [1] [2] [NEW] [] []
     *
     * @param element element for adding
     */
    @Override
    public void strictAdd(T element) {
        for (int i = 0; i < size(); i++) {
            if (fixedArray[i] == null) {
                fixedArray[i] = SystemUtils.clone(element);
                return;
            }
        }
        throw new IncorrectSizeException("There is no vacant place for new element");
    }

    /**
     * Strict removing element on adjusted index
     *
     * @param index element's index in array
     */
    @Override
    public void strictRemove(int index) {
        StructureUtils.checkingIndex(index, size());
        strictLeftShifting(index);
    }

    /**
     * Deleting element on given index form array
     * NULL-value is being set instead element on given index
     *
     * @param index index of deleting element
     */
    @Override
    public void delete(int index) {
        StructureUtils.checkingIndex(index, size());
        fixedArray[index] = null;
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
            if (fixedArray[i].equals(element))
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedArray<T> array1 = (FixedArray<T>) o;
        if (maxSize != array1.maxSize) return false;

        for (int i = 0; i < maxSize; i++) {
            if (fixedArray[i] == null || array1.fixedArray[i] == null) {
                if (fixedArray[i] == null && array1.fixedArray[i] != null)
                    return false;
                if (fixedArray[i] != null && array1.fixedArray[i] == null)
                    return false;
            } else {
                if (!fixedArray[i].equals(array1.fixedArray[i]))
                    return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * maxSize;
        for (int i = 0; i < maxSize; i++) {
            if (fixedArray[i] != null) {
                result += 31 * fixedArray[i].hashCode();
            } else {
                result += 31;
            }
        }
        return result;
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
            fixedArray[i] = fixedArray[i + 1];
        }
        fixedArray[size() - 1] = null;
    }

    /**
     * Strict array left shifting
     * <p>
     * Consider [1] [2] [3] [4]. We have to shift array since index = 1
     * Then we have [1] [3] [4] [NULL]
     *
     * @param startWithIndex first index for shifting
     */
    private void strictLeftShifting(int startWithIndex) {
        for (int i = startWithIndex; i < size() - 1; i++) {
            fixedArray[i] = SystemUtils.clone(fixedArray[i + 1]);
        }
        fixedArray[size() - 1] = null;
    }
}