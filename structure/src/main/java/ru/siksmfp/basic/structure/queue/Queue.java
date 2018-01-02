package ru.siksmfp.basic.structure.queue;


import com.saiu.dataStructures.dynamicArray.Array;
import com.saiu.dataStructures.exceptions.MistakenDeckSize;
import com.saiu.dataStructures.utils.SystemUtils;

import static com.saiu.dataStructures.utils.SystemUtils.checkDataStructureSize;
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
     * Queue initialization
     */
    public Queue() {
        size = 0;
        array = new Array<>();
    }

    /**
     * Pushing element into queue
     *
     * @param element element for pushing
     */
    public void push(T element) {
        checkDataStructureSize(size);
        array.add(element);
        size++;
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
     * Checking queue on elements presence
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
    public boolean contains(T element) {
        return array.contains(element);
    }
}