
package ru.siksmfp.basic.structure.list.iterator;

import ru.siksmfp.basic.structure.api.Iterator;
import ru.siksmfp.basic.structure.api.ListStructure;

/**
 * @author Artem Karnov @date 1/8/2018.
 * artem.karnov@t-systems.com
 */
public class ListIterator<T> implements Iterator<T> {

    public ListIterator(ListStructure<T> listStructure) {

    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void insertBefore() {

    }

    @Override
    public void insertAfter() {

    }

    @Override
    public void deleteCurrent() {

    }
}
