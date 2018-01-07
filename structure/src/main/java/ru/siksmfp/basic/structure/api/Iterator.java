package ru.siksmfp.basic.structure.api;

/**
 * @author Artem Karnov @date 1/8/2018.
 * artem.karnov@t-systems.com
 */
public interface Iterator<T> {
    boolean hasNext();

    boolean isLast();

    boolean isFirst();

    void reset();

    T next();

    void insertBefore();

    void insertAfter();

    void deleteCurrent();
}
