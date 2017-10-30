package com.saiu.dataStructures.queue;


import com.saiu.dataStructures.dynamicArray.Array;
import com.saiu.dataStructures.exceptions.MistakenDeckSize;
import com.saiu.dataStructures.exceptions.MistakenStackSize;
/**
 * @author Artem Karnov @date 21.02.17.
 * artem.karnov@t-systems.com
 */


/**
 * Queue built on dynamic array
 *
 * @param <T> object type for storing in queue
 */
public class Queue<T> {
    private Array<T> array;
    private int size;

    /**
     * Deck initialization
     */
    public Queue() {
        size = 0;
        array = new Array<T>();
    }

    /**
     * Pushing element into queue
     *
     * @param element element for pushing
     */
    public void push(T element) {
        if (size < Integer.MAX_VALUE) {
            array.add(element);
            size++;
        } else {
            throw new MistakenStackSize("Size is too big for storing");
        }
    }

    /**
     * Extraction first element from queue
     *
     * @return extracted element
     */
    public T pop() {
        if (size > 0) {
            T element = array.get(0);
            array.remove(0);
            size--;
            return element;
        } else {
            throw new MistakenDeckSize("Deck is empty");
        }
    }

    /**
     * Checking com.saiu.dataStructures.queue on elements presence
     *
     * @return true - if queue has elements, false - if queue is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Getting queue size
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
     * @return true - if queue contain adjusted element, false - if doesn't
     */
    public boolean contain(T element) {
        return array.contains(element) ? true : false;
    }
}