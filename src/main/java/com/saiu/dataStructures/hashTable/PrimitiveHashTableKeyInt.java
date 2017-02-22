package com.saiu.dataStructures.hashTable;

/**
 * @author Artem Karnov @date 22.02.2017.
 * artem.karnov@t-systems.com
 */

/**
 * Implementation of simple hash table with mod hash function
 *
 * @param <T> object type for storing in hash table
 */
public class PrimitiveHashTableKeyInt<T> {
    private T array[];
    private int size;

    /**
     * Constructor with size initialization
     *
     * @param size size of table
     */
    public PrimitiveHashTableKeyInt(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    /**
     * Simple hash function. Mod operation is using for getting hash
     *
     * @param key key for calculation
     * @return hash code of key
     */
    private int getHash(int key) {
        return key % size;
    }

    /**
     * Getting data by key from hash table
     *
     * @param key key for getting
     * @return @nullable data associated with key
     */
    public T getData(int key) {
        return array[getHash(key)];
    }

    /**
     * Removing data by key
     *
     * @param key key for removing
     */
    public void remove(int key) {
        array[getHash(key)] = null;
    }

    /**
     * Addition row to table
     *
     * @param key  key of row
     * @param data data of row
     */
    public void add(int key, T data) {
        int hashedKey = getHash(key);
        while (true) {
            if (array[hashedKey] == null) {
                array[hashedKey] = data;
                return;
            } else {
                if (hashedKey < size - 1)
                    hashedKey++;
                else {
                    return;
                }
            }
        }
    }

    /**
     * Showing all data of hash table
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
     * @param data data for getting
     * @return -1 if data doesn't exist, key of row if data exists
     */
    public int getDataKey(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(array[i]))
                return i;
        }
        return -1;
    }
}
