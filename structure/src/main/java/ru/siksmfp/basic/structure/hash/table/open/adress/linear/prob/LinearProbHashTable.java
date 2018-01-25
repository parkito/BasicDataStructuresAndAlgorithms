package ru.siksmfp.basic.structure.hash.table.open.adress.linear.prob;


import ru.siksmfp.basic.structure.api.ArrayStructure;
import ru.siksmfp.basic.structure.api.HashTable;
import ru.siksmfp.basic.structure.array.fixed.FixedArray;

import java.util.function.Function;

/**
 * @param <T> object type for storing in hash table
 *            Implementation of simple hash table with mod hash function.
 *            Realization of hash table very dump and ineffective.
 *            1)Dump collision solver with randomize sub-element
 *            2)Dump size allocator
 * @author Artem Karnov @date 1/10/2018.
 * @email artem.karnov@t-systems.com
 * <p>
 */
public class LinearProbHashTable<T> implements HashTable<T> {
    private final Function<T, Integer> DEFAULT_HASH_FUNCTION = t -> {
        int i = t.hashCode();
        i ^= (i << 13);
        i ^= (i >>> 17);
        i ^= (i << 5);
        return i;
    };
    private ArrayStructure<T> array;
    private Function<T, Integer> hashFunction;


    /**
     * Constructor with size initialization
     *
     * @param size size of table
     */
    public LinearProbHashTable(int size) {
        array = new FixedArray<T>(size);
        hashFunction = DEFAULT_HASH_FUNCTION;
    }


    /**
     * Getting data by key from hash table
     *
     * @param key key for getting
     * @return @nullable data associated with key
     */
    public T getData(int key) {
//        return array[getHash(key)];
        return null;
    }

    @Override
    public void add(T element) {

    }

    @Override
    public int getHash(T element) {
        return hashFunction.apply(element);
    }

    @Override
    public ArrayStructure<T> get(int hash) {
        return null;
    }

    @Override
    public void setHashFunction(Function<T, Integer> hashFunction) {

    }

    @Override
    public void remove(int key) {

    }

    @Override
    public void remove(int key, T element) {

    }
}
