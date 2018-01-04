package ru.siksmfp.basic.structure.queue;


import ru.siksmfp.basic.structure.array.dynamic.Array;
import ru.siksmfp.basic.structure.exceptions.IncorrectSizeException;
import ru.siksmfp.basic.structure.utils.StructureUtils;


/**
 * @param <T> object type for storing in queue
 *            Queue built on dynamic array
 * @author Artem Karnov @date 21.02.17.
 * artem.karnov@t-systems.com
 * <p>
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
        StructureUtils.checkDataStructureSize(size);
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
            throw new IncorrectSizeException("Queue is empty");
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