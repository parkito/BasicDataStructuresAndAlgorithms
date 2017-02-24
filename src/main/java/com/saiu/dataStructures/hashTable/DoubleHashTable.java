package com.saiu.dataStructures.hashTable;

/**
 * @author Artem Karnov @date 22.02.2017.
 * artem.karnov@t-systems.com
 */

import java.util.Random;

/**
 * Implementation of doubleHashing hash table with mod hash function.
 *
 * @param <T> object type for storing in hash table
 */
public class DoubleHashTable<T> {
    private T array[];
    private int size;
    private int SECONDARY_HASH_CONSTANT;
    private Random random;

    public DoubleHashTable() {
    }

    /**
     * Constructor with size initialization
     *
     * @param optimalSize size of table for optimal table building
     */
    public DoubleHashTable(int optimalSize) {
        SECONDARY_HASH_CONSTANT = optimalSize % (optimalSize / 3);
        optimalSize = optimalSize * 2;
        this.size = optimalSize;
        this.array = (T[]) new Object[size];
    }

    /**
     * Simple primary hash function. Mod operation is using for getting hash
     *
     * @param key key for calculation
     * @return hash code of key
     */
    private int getPrimaryHash(int key) {
        return key % size;
    }

    /**
     * Checking number for primary type
     *
     * @param number number for checking
     * @return true - if number is primary, false - if number is not primary
     */
    private boolean isPrimeNumber(int number) {
        int i = 2, j = 0;
        while (i * i < number && j != 1) {
            if (number % i == 0)
                j = 1;
            i++;
        }
        return j == 1 ? false : true;
    }

    private int getPrimeNumberMoreThan(int number) {
        return 1;
    }

    /**
     * Simple primary hash function. Mod operation is using for getting hash
     *
     * @param key key for calculation
     * @return hash code of key
     */
    private int getSecondaryHash(int key) {
        return SECONDARY_HASH_CONSTANT - (key % SECONDARY_HASH_CONSTANT);
    }

    /**
     * Getting data by key from hash table
     *
     * @param key key for getting
     * @return @nullable data associated with key
     */
    public T getData(int key) {
        int hashVal = getPrimaryHash(key);
        int stepSize = getSecondaryHash(key);
        while (array[hashVal] != null) {
            if (hashVal == key) {
                T temp = array[hashVal];
                return temp;
            }
            hashVal += stepSize;
            hashVal %= size;
        }
        return null;
    }

    /**
     * Addition row to table
     *
     * @param key  key of row
     * @param data data of row
     */
    public void add(int key, T data) {
        int hashVal = getPrimaryHash(key);
        int stepSize = getSecondaryHash(key);
        while (array[hashVal] != null) {
            ++hashVal;
            hashVal %= stepSize;
            hashVal %= size;
        }
        array[hashVal] = data;
    }


    /**
     * Removing data by key
     *
     * @param key key for removing
     */
    public void remove(int key) {
        array[getPrimaryHash(key)] = null;
    }

    /**
     * Smart removing data by key
     *
     * @param key key for removing
     */
    public T delete(int key) {
        int hashVal = getPrimaryHash(key);
        int stepSize = getSecondaryHash(key);
        while (array[hashVal] != null) {
            if (hashVal == key) {
                T temp = array[hashVal];
                array[hashVal] = null;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= size;
        }
        return null;
    }

    /**
     * * Showing all data of hash table
     */
    public void showHashTable() {
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                System.out.println("{" + i + ";" + array[i] + "}");
            }
        }
    }

    /**
     * Showing row with adjusted data
     *
     * @param data
     */
    public void showRow(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(array[i]))
                System.out.println("{" + i + ";" + array[i] + "}");
            return;
        }
        System.out.println("Data wasn't found");
    }

    /**
     * Getting key by first met data member
     *
     * @param data data for getting
     * @return @warning -1 if data doesn't exist, key of row if data exists
     */
    public int getDataKey(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(array[i]))
                return i;
        }
        return -1;
    }
}
