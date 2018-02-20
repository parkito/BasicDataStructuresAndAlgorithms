package ru.siksmfp.basic.structure.tree.doubled.seacrh.tree;

/**
 * @author Artem Karnov @date 08.12.16.
 * artem.karnov@t-systems.com
 **/
public class SearchTree<K extends Comparable<K>, V> {

    public class Node<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Node<K, V> leftChildren;
        private Node<K, V> rightChildren;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.rightChildren = null;
            this.leftChildren = null;
        }

        public String toString() {
            return "Node{key " + key + ", value " + value + ", left child " + leftChildren + ", right child " + rightChildren + "}";
        }
    }

    private Node<K, V> root;
    private int size;

    public SearchTree() {
        root = null;
    }

    /**
     * Addition list after max value
     *
     * @param value value for adding
     */
    public void add(K key, V value) {
        Node<K, V> currentNode = root, parent = root;
        while (currentNode != null) {
            parent = currentNode;
            if (currentNode.key.compareTo(key) < 0) {
                currentNode = currentNode.leftChildren;
            } else {
                currentNode = currentNode.rightChildren;
            }
        }
        currentNode = new Node<>(key, value);
        size++;
        if (parent != null) {
            if (parent.key.compareTo(key) < 0)
                parent.leftChildren = currentNode;
            else {
                parent.rightChildren = currentNode;
            }
        }
    }

    /**
     * Searching list's value by value
     *
     * @return list's value if element exists, null if doesn't
     */
    public boolean contains(V value) {
        return inOrder(root, value);
    }

    /**
     * Searching list's value by key
     *
     * @return list's value if element exists, null if doesn't
     */
    public boolean contains(K key) {
        Node<K, V> currentNode = root;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return true;
            } else if (currentNode.key.compareTo(key) < 0) {
                currentNode = currentNode.leftChildren;
            } else {
                currentNode = currentNode.rightChildren;
            }
        }
        return false;
    }

    private boolean inOrder(Node<K, V> localRoot, V value) {
        if (localRoot != null) {
            boolean leftResult = inOrder(localRoot.leftChildren, value);
            if (leftResult) {
                return true;
            }
            if (localRoot.value.equals(value)) {
                return true;
            } else {
                return inOrder(localRoot.rightChildren, value);
            }
        } else {
            return false;
        }
    }

    /**
     * Removing element with key
     *
     * @param key for key removing
     */
    public void remove(K key) {
        Node<K, V> currentNode = root, parent = root;
        while (currentNode != null) {
            if (currentNode.value.equals(key)) {
                if (currentNode.leftChildren == null && currentNode.rightChildren == null) {
                    currentNode = null;
                } else if (currentNode.leftChildren == null) {
                    if (currentNode.key.compareTo(parent.key) < 0) {
                        parent.leftChildren = currentNode.rightChildren;
                    } else {
                        parent.rightChildren = currentNode.rightChildren;
                    }
                    currentNode = null;
                } else if (currentNode.rightChildren != null) {
                    if (currentNode.key.compareTo(parent.key) < 0) {
                        parent.leftChildren = currentNode.leftChildren;
                    } else {
                        parent.rightChildren = currentNode.leftChildren;
                    }
                    currentNode = null;
                } else {
                    Node<K, V> leftNode = currentNode.leftChildren;
                    Node<K, V> rightNode = currentNode.rightChildren;
                    Node<K, V> successor = findSuccessor(currentNode);
                    successor.leftChildren = leftNode;
                    successor.rightChildren = rightNode;
                }
            }
        }
    }

    /**
     * Getting successor for deleting list with two children
     *
     * @param firstNode list for getting
     * @return successor
     */
    private Node<K, V> findSuccessor(Node<K, V> firstNode) {
        Node<K, V> successor = firstNode;
        Node<K, V> successorParent = firstNode;
        Node<K, V> current = firstNode.rightChildren;
        while (current != null) {
            successorParent = successor;
            successor = current;
            if (current.leftChildren != null) {
                current = current.leftChildren;
            } else {
                current = current.rightChildren;
            }
        }
        if (successorParent != successor) {
            if (successor.leftChildren == successor) {
                successorParent.leftChildren = null;
            } else {
                successorParent.rightChildren = null;
            }
        }
        return successor;
    }
}
