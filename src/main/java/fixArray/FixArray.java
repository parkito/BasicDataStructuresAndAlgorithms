package fixArray;

import exceptions.MistakenArraySize;
import exceptions.MistakenIndex;

/**
 * Created by Artyom Karnov on 15.11.16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Array of fix length. Non initialized elements - 0
 *
 * @param <T> object type for storing in array
 */
public class FixArray<T> {
    private int maxSize;
    Object[] fixArray;

    /**
     * Constructor for getting array's size and initialization
     *
     * @param size array size
     */
    public FixArray(int size) {
        this.maxSize = size;
        if (size <= 0) {
            throw new MistakenArraySize("Size couldn't be <=0");
        } else if (size < Integer.MAX_VALUE) {
            fixArray = new Object[size];
            arrayInitialization();
        } else {
            throw new MistakenArraySize("Array overflow");
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
            throw new MistakenIndex("Index couldn't be <0");
        } else if (position < maxSize) {
            return (T) fixArray[position];
        } else {
            throw new MistakenArraySize("Index overflow");
        }
    }

    /**
     * Addition new element on adjusted position
     *
     * @param element  element for adding
     * @param position position of adding
     */
    public void add(T element, int position) {
        if (position < 0) {
            throw new MistakenIndex("Index couldn't be <0");
        } else if (position < maxSize) {
            fixArray[position] = element;
        } else {
            throw new MistakenIndex("Mistaken index");
        }
    }

    /**
     * Removing element on adjusted position
     *
     * @param position element's position in array
     */
    public void remove(int position) {
        if (position < 0) {
            throw new MistakenIndex("Index couldn't be <0");
        } else if (position < maxSize) {
            fixArray[position] = Integer.valueOf(0);
        } else {
            throw new MistakenIndex("Incorrect size");
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