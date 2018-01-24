//package ru.siksmfp.basic.structure.hash.table.simple;
//
//
//import ru.siksmfp.basic.structure.api.ArrayStructure;
//import ru.siksmfp.basic.structure.api.HashTable;
//import ru.siksmfp.basic.structure.array.fixed.FixedArray;
//
//import java.util.Random;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
///**
// * @param <T> object type for storing in hash table
// *            Implementation of simple hash table with mod hash function.
// *            Realization of hash table very dump and ineffective.
// *            1)Dump collision solver with randomize sub-element
// *            2)Dump size allocator
// * @author Artem Karnov @date 22.02.2017.
// * artem.karnov@t-systems.com
// * <p>
// */
//public class LinearProbHashTable<T> implements HashTable<T> {
//    private ArrayStructure<T> array;
//    private Function<T, Long> hashFunction;
//
//
//    /**
//     * Constructor with size initialization
//     *
//     * @param size size of table
//     */
//    public LinearProbHashTable(int size) {
//        array = new FixedArray<T>(size);
//        hashFunction=
//    }
//
//    /**
//     * Simple hash function. Mod operation is using for getting hash
//     *
//     * @param key key for calculation
//     * @return hash code of key
//     */
//    private int getHash(int key) {
//        return key % size;
//    }
//
//    /**
//     * Getting data by key from hash table
//     *
//     * @param key key for getting
//     * @return @nullable data associated with key
//     */
//    public T getData(int key) {
//        return array[getHash(key)];
//    }
//
//    /**
//     * Addition row to table
//     *
//     * @param key  key of row
//     * @param data data of row
//     */
//    public void add(int key, T data) {
//        int hashedKey = getHash(key);
//        while (true) {
//            if (array[hashedKey] == null) {
//                array[hashedKey] = data;
//                return;
//                //if key already has data
//            } else {
//                if (hashedKey < size - 1)
//                    hashedKey++;
//                else {
//                    return;
//                }
//            }
//        }
//    }
//
//    /**
//     * Addition row to table with key generation and linear hashing
//     * Required more effective method for collision solving
//     *
//     * @param data data of row
//     */
//    @Deprecated
//    public int simpleAdd(T data) {
//        int key = random.nextInt(size);
//        int hashedKey = getHash(key);
//        while (true) {
//            if (array[hashedKey] == null) {
//                array[hashedKey] = data;
//                return hashedKey;
//            } else {
//                if (hashedKey < size - 1)
//                    hashedKey++;
//                else {
//                    return -1;
//                }
//            }
//        }
//    }
//
//    /**
//     * Optimal addition row to table with key generation and linear hashing
//     *
//     * @param data data of row
//     */
//    public void add(T data) {
//        int key = random.nextInt(size);
//        int hashVal = getHash(key);
//        while (array[hashVal] != null) {
//            ++hashVal;
//            hashVal %= size;
//        }
//        array[hashVal] = data;
//    }
//
//    @Override
//    public long getHash(T element) {
//        return 0;
//    }
//
//    @Override
//    public ArrayStructure<T> get(long hash) {
//        return null;
//    }
//
//    @Override
//    public void setHashFunction(Function<T, Long> hashFunction) {
//
//    }
//
//    @Override
//    public void remove(long key) {
//
//    }
//
//    @Override
//    public void remove(long key, T element) {
//
//    }
//
//    private long calculateHash(T element) {
//
//    }
//}
