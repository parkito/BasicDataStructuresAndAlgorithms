package stack;

import dynamicArray.DynamicArray;
import exceptions.MistakenStackSize;

/**
 * Created by Artyom Karnov on 18.11.16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Stack built on dynamic array
 *
 * @param <T> object type for storing in stack
 */
public class Stack<T> {
    private DynamicArray<T> dynamicArray;
    private int size;

    /**
     * Stack initialization
     */
    public Stack() {
        size = 0;
        dynamicArray = new DynamicArray<T>();
    }

    /**
     * Pushing element into stack
     *
     * @param element element for pushing
     */
    public void push(T element) {
        if (size < Integer.MAX_VALUE) {
            dynamicArray.add(element);
            size++;
        } else {
            throw new MistakenStackSize("Size is too big for storing");
        }
    }

    /**
     * Extraction upper element from stack
     *
     * @return extracted element
     */
    public T pop() {
        if (size > 0) {
            T temp = dynamicArray.get(size - 1);
            size--;
            return temp;
        } else {
            throw new MistakenStackSize("Stack is empty");
        }
    }

    /**
     * Checking stack on elements presence
     *
     * @return true - if stack has elements, false - if stack is empty
     */
    public boolean isEmpty() {
        if (size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Getting stack size
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
     * @return true - if stack contain adjusted element, false - if doesn't
     */
    public boolean contain(T element) {
        return dynamicArray.contains(element) ? true : false;
    }
}