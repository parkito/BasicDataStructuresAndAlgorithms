package ru.siksmfp.basic.structure.array.dynamic;

import ru.siksmfp.basic.structure.exceptions.IncorrectIndexException;
import ru.siksmfp.basic.structure.exceptions.IncorrectSizeException;
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
    private int size;
    private Object array[];

    /**
     * Constructor without parameters
     */
    public Array() {
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
        this.size = size;
        if (size <= 0) {
            throw new IncorrectSizeException("Size couldn't be <=0");
        } else if (size < Integer.MAX_VALUE) {
            array = new Object[size];
            arrayInitialization();
        } else {
            throw new IncorrectSizeException("Array overflow");
        }
    }

    /**
     * Method for initialization array before work
     */
    private void arrayInitialization() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
    }

    /**
     * Addition new element to array
     */
    public void add(T element) {
        if (size < Integer.MAX_VALUE) {
            array = arrayCopy(element);
            size++;
        } else {
            throw new IncorrectSizeException("Array overflow");
        }
    }

    /**
     * Add element on given position
     *
     * @param element  element for adding
     * @param position position of adding element
     */
    public void add(T element, int position) {
        if (position < 0) {
            throw new IncorrectSizeException("Size couldn't be less than 0");
        } else if (position >= size) {
            throw new IncorrectSizeException("Index " + position + " is greater than size of array " + size);
        } else {
            array[position] = element;
        }
    }

    /**
     * Add element to array by deep copying of element
     *
     * @param element element for adding
     */
    public void strictAdd(T element) {
        if (size < Integer.MAX_VALUE) {
            array = strictArrayCopy(element);
            size++;
        } else {
            throw new IncorrectSizeException("Array overflow");
        }
    }

    /**
     * Add element on given position by deep copying of element
     *
     * @param element  element for adding
     * @param position position of adding element
     */
    public void strictAdd(T element, int position) {
        if (position < 0) {
            throw new IncorrectSizeException("Size couldn't be less than 0");
        } else if (position >= size) {
            throw new IncorrectSizeException("Index " + position + " is greater than size of array " + size);
        } else {
            array[position] = SystemUtils.clone(element);
        }
    }

    /**
     * Support method for element addition
     *
     * @param newElement modified array
     * @return new array with additional element
     */
    private Object[] arrayCopy(Object newElement) {
        Object copyTo[] = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            copyTo[i] = array[i];
        }
        copyTo[size] = newElement;
        return copyTo;
    }

    /**
     * Support method for strict element addition
     *
     * @param newElement modified array
     * @return new array with additional element
     */
    private Object[] strictArrayCopy(Object newElement) {
        Object copyTo[] = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            copyTo[i] = SystemUtils.clone(array[i]);
        }
        copyTo[size] = newElement;
        return copyTo;
    }

    /**
     * Getting element on adjusted position in array
     *
     * @param position position of element
     * @return element on adjusted position
     */
    public T get(int position) {
        if (position < 0) {
            throw new IncorrectIndexException("Index of element couldn't be less than 0");
        } else if (position < size) {
            return (T) array[position];
        } else {
            throw new IncorrectSizeException("Index overflow");
        }
    }

    /**
     * Removing element on adjusted position
     *
     * @param position element's position in array
     */
    public void remove(int position) {
        if (size <= 0) {
            throw new IncorrectSizeException("Size couldn't be less than 0");
        } else {
            array = offset(position);
            size--;
        }
    }

    /**
     * Strict removing element on given position
     * There is deep copying during element's offset
     *
     * @param position position of removing element
     */
    public void strictRemove(int position) {
        if (size <= 0) {
            throw new IncorrectSizeException("Size couldn't be less than 0");
        } else {
            array = strictOffset(position);
            size--;
        }
    }

    /**
     * Deleting element on given position form array
     * NULL-value is being set instead element on given position
     *
     * @param position position of deleting element
     */
    public void delete(int position) {
        if (size <= 0) {
            throw new IncorrectSizeException("Size couldn't be less than 0");
        } else {
            array[position] = null;
        }
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
}