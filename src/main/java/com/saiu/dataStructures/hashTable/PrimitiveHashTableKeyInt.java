package com.saiu.dataStructures.hashTable;

/**
 * @author Artem Karnov @date 22.02.2017.
 *         artem.karnov@t-systems.com
 */

public class PrimitiveHashTableKeyInt<T> {
    private T array[];
    private int size;

    public PrimitiveHashTableKeyInt(int size) {
        size *= 2;
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    private int getHash(int key) {
        return key % size;
    }

    public T getData(int key) {
        return array[getHash(key)];
    }

    public void remove(int key) {
        array[getHash(key)] = null;
    }

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
                    hashedKey %= size;
                    return;
                }
            }
        }
    }

    public void showHashTable() {
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                System.out.println("{" + i + ";" + array[i] + "}");
            }
        }
    }
}
