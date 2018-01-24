package ru.siksmfp.basic.structure.api;

import java.util.function.Consumer;
import java.util.function.Function;

public interface HashTable<T> {
    void add(T element);

    long getHash(T element);

    ArrayStructure<T> get(long hash);

    void setHashFunction(Function<T, Long> hashFunction);

    void remove(long key);

    void remove(long key, T element);

}
