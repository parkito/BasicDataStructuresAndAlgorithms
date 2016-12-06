package deck;

import dynamicArray.DynamicArray;
import exceptions.MistakenDeckSize;
import exceptions.MistakenStackSize;

/**
 * @author Artem Karnov @date 02.12.16.
 * artem.karnov@t-systems.com
 **/

/**
 * Deck built on dynamic array
 *
 * @param <T> object type for storing in stack
 */
public class Deck<T> {
    private DynamicArray<T> dynamicArray;
    private int size;

    /**
     * Deck initialization
     */
    public Deck() {
        size = 0;
        dynamicArray = new DynamicArray<T>();
    }

    /**
     * Pushing element into deck
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
     * Extraction first element from deck
     *
     * @return extracted element
     */
    public T pop() {
        if (size > 0) {
            T element = dynamicArray.get(0);
            dynamicArray.remove(0);
            size--;
            return element;
        } else {
            throw new MistakenDeckSize("Deck is empty");
        }
    }

    /**
     * Checking deck on elements presence
     *
     * @return true - if deck has elements, false - if deck is empty
     */
    public boolean isEmpty() {
        if (size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Getting deck size
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
     * @return true - if deck contain adjusted element, false - if doesn't
     */
    public boolean contain(T element) {
        return dynamicArray.contains(element) ? true : false;
    }
}