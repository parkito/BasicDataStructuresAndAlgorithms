package dynamicArray;

import exceptions.MistakenArraySize;
import exceptions.MistakenIndex;

/**
 * Created by Artyom Karnov on 17.11.16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Array of variable length. Non initialized elements - 0
 *
 * @param <T> object type for storing in array
 */
public class DynamicArray<T> {
    private int size;
    private Object dynamicArray[];

    /**
     * Constructor without parametrs
     */
    public DynamicArray() {
    }

    /**
     * Constructor for getting array's size and initialization
     *
     * @param size array size
     */
    public DynamicArray(int size) {
        this.size = size;
        if (size <= 0) {
            throw new MistakenArraySize("Size couldn't be <=0");
        } else if (size < Integer.MAX_VALUE) {
            dynamicArray = new Object[size];
            arrayInitialization();
        } else {
            throw new MistakenArraySize("Array overflow");
        }
    }

    /**
     * Method for initialization array before work
     */
    private void arrayInitialization() {
        for (int i = 0; i < size; i++) {
            dynamicArray[i] = Integer.valueOf(0);
        }
    }

    /**
     * Addition new element to array
     *
     * @param position position of adding
     */
    public void add(T element) {
        if (size < Integer.MAX_VALUE) {
            dynamicArray = arrayCopy(element);
            size++;
        } else {
            throw new MistakenArraySize("Array overflow");
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
            copyTo[i] = dynamicArray[i];
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
            throw new MistakenIndex("Index of element couldn't be <0");
        } else if (position < size) {
            return (T) dynamicArray[position];
        } else {
            throw new MistakenArraySize("Index overflow");
        }
    }

    /**
     * Removing element on adjusted position
     *
     * @param position element's position in array
     */
    public void remove(int position) {
        if (size <= 0) {
            throw new MistakenArraySize("Size couldn't be <=0");
        } else if (position > Integer.MAX_VALUE) {
            throw new MistakenArraySize("Index overflow");
        } else {
            dynamicArray = offset(position);
            size--;
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
        for (int i = 0; i < size-1; i++) {
            if (i >= position) {
                offsetArray[i] = dynamicArray[i + 1];
            } else {
                offsetArray[i] = dynamicArray[i];
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
            if (dynamicArray[i].equals(element))
                return true;
        }
        return false;
    }
}