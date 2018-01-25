package ru.siksmfp.basic.structure.api;

import java.util.function.Function;

public interface HashTable<T> {
    void add(T element);

    int getHash(T element);

    ArrayStructure<T> get(int hash);

    void setHashFunction(Function<T, Integer> hashFunction);

    void remove(int key);

    void remove(int key, T element);

}
