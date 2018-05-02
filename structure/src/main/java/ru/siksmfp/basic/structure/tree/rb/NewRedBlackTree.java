package ru.siksmfp.basic.structure.tree.rb;

import ru.siksmfp.basic.structure.api.TreeStructure;

/**
 * @author Artem Karnov @date 5/2/2018.
 * @email artem.karnov@t-systems.com
 */
public class NewRedBlackTree<K extends Comparable<K>, V> implements TreeStructure<K, V> {

    /**
     * Model of node's tree
     */
    private class Node {
        private K key;
        private V value;
        private boolean isRed;
        private boolean isLeftChild;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.isRed = true;
            this.isLeftChild = false;
            this.parent = null;
            this.rightChild = null;
            this.leftChild = null;
        }

        public String toString() {
            String leftChildrenKey = leftChild == null ? "null" : leftChild.key == null ? "null" : leftChild.key.toString();
            String leftChildrenValue = leftChild == null ? "null" : leftChild.value == null ? "null" : leftChild.value.toString();
            String rightChildrenKey = rightChild == null ? "null" : rightChild.key == null ? "null" : rightChild.key.toString();
            String rightChildrenValue = rightChild == null ? "null" : rightChild.value == null ? "null" : rightChild.value.toString();
            String color = isRed ? "Red" : "Black";
            String parentKey = parent == null ? "null" : parent.key.toString();
            String parentColor = parent == null ? "null" : parent.isRed ? "Red" : "Black";

            return "Node{key " + key + ", value " + value + ", color " + color
                    + ", left child (" + leftChildrenKey + ";" + leftChildrenValue + ")"
                    + "; right child (" + rightChildrenKey + ";" + rightChildrenValue + ")"
                    + " parent (" + parentKey + ";" + parentColor + ") }";
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {

    }

    @Override
    public void strictAdd(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void removeValue(V value) {

    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    //   Left-rotate
    //
    //                x        --->          y
    //             a     y                 x    l
    //                 b   l             a   b
    //
    private void leftRotate(Node node) {
    }

    //   Right-rotate
    //
    //                y        --->       x
    //             x    l              a     y
    //           a   b                     b   l
    //
    private void rightRotate(Node node) {

    }
}
