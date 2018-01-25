package ru.siksmfp.basic.structure.hash.table.open.adress.linear.prob;


import ru.siksmfp.basic.structure.api.ArrayStructure;
import ru.siksmfp.basic.structure.api.HashTable;
import ru.siksmfp.basic.structure.array.fixed.FixedArray;
import ru.siksmfp.basic.structure.exceptions.IncorrectSizeException;
import ru.siksmfp.basic.structure.utils.math.Math;

import java.util.function.Function;

/**
 * @author Artem Karnov @date 1/10/2018.
 * @email artem.karnov@t-systems.com
 */
public class LinearProbHashTable<K, V> implements HashTable<K, V> {
    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Function<K, Integer> DEFAULT_HASH_FUNCTION = t -> {
        int i = t.hashCode();
        i = (i + 0x7ed55d16) + (i << 12);
        i = (i ^ 0xc761c23c) ^ (i >> 19);
        i = (i + 0x165667b1) + (i << 5);
        i = (i + 0xd3a2646c) ^ (i << 9);
        i = (i + 0xfd7046c5) + (i << 3);
        i = (i ^ 0xb55a4f09) ^ (i >> 16);
        return i > 0 ? i : -i;
    };
    private ArrayStructure<Node<K, V>> array;
    private Function<K, Integer> hashFunction;
    private int size;

    /**
     * Constructor with size initialization
     *
     * @param size size of table
     */
    public LinearProbHashTable(int size) {
        array = new FixedArray<>(Math.getFirstSimpleNumberAfter(size));
        hashFunction = DEFAULT_HASH_FUNCTION;
    }

    @Override
    public void add(K key, V value) {
        int index = applyHashing(key);
        if (array.get(index) == null) {
            array.add(index, new Node<>(key, value));
            size++;
        } else {
            int i = index + 1;
            while (i != index) {
                if (i >= array.size()) {
                    i = 0;
                } else if (array.get(i) == null) {
                    array.add(i, new Node<>(key, value));
                    size++;
                    return;
                } else {
                    i++;
                }
            }
            throw new IncorrectSizeException("There is no space for new element");
        }
    }

    @Override
    public int getHash(K key) {
        return hashFunction.apply(key);
    }

    @Override
    public V get(K key) {
        int index = applyHashing(key);
        if (array.get(index) != null && array.get(index).key.equals(key)) {
            return array.get(index).value;
        } else {
            int i = index + 1;
            while (i != index) {
                if (i >= array.size()) {
                    i = 0;
                } else if (array.get(i) != null && array.get(i).key.equals(key)) {
                    return array.get(i).value;
                } else {
                    i++;
                }
            }
            return null;
        }
    }

    @Override
    public void setHashFunction(Function<K, Integer> hashFunction) {
        this.hashFunction = hashFunction;
    }

    @Override
    public void remove(K key) {
        int index = applyHashing(key);
        if (array.get(index) != null && array.get(index).key.equals(key)) {
            array.add(index, null);
            size--;
        } else {
            int i = index + 1;
            while (i != index) {
                if (i >= array.size()) {
                    i = 0;
                } else if (array.get(i) != null && array.get(i).key.equals(key)) {
                    array.add(i, null);
                    size--;
                    return;
                } else {
                    i++;
                }
            }
        }
    }

    @Override
    public void delete(K key) {
        int index = applyHashing(key);
        if (array.get(index).key.equals(key)) {
            array.get(index).value = null;
        } else {
            int i = index + 1;
            while (i != index) {
                if (i >= array.size()) {
                    i = 0;
                } else if (array.get(i) != null && array.get(i).key.equals(key)) {
                    array.get(i).value = null;
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                result.append("(")
                        .append(array.get(i).key)
                        .append(";")
                        .append(array.get(i).value)
                        .append("), ");
            } else {
                result.append("null, ");
            }

        }
        if (result.length() > 1) {
            result.delete(result.length() - 2, result.length());
        }
        return "LinearProbHashTable{" + result.toString() + "}";
    }

    private int applyHashing(K key) {
        return hashFunction.apply(key) % array.size();
    }
}
