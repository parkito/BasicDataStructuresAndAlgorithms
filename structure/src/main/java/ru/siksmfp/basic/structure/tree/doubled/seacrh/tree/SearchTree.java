package ru.siksmfp.basic.structure.tree.doubled.seacrh.tree;

import ru.siksmfp.basic.structure.api.TreeStructure;
import ru.siksmfp.basic.structure.utils.SystemUtils;

import java.util.function.BiConsumer;

/**
 * @author Artem Karnov @date 08.12.16.
 * artem.karnov@t-systems.com
 **/
public class SearchTree<K extends Comparable<K>, V> implements TreeStructure<K, V> {
    /**
     * Model of node's tree
     */
    public class Node {
        private K key;
        private V value;
        private Node leftChildren;
        private Node rightChildren;

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

    private Node root;
    private int size;

    public SearchTree() {
        root = null;
    }

    /**
     * Inserting element in tree
     *
     * @param key   key for ordering
     * @param value value for storing
     */
    @Override
    public void add(K key, V value) {
        Node currentNode = root, parent = root;
        while (currentNode != null) {
            parent = currentNode;
            if (currentNode.key.compareTo(key) < 0) {
                currentNode = currentNode.leftChildren;
            } else {
                currentNode = currentNode.rightChildren;
            }
        }
        currentNode = new Node(key, value);
        if (root == null) {
            root = currentNode;
        }
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
     * Getting element by key
     *
     * @param key key for getting
     * @return value of store element, null - if element isn't in tree
     */
    @Override
    public V get(K key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.key.compareTo(key) < 0) {
                currentNode = currentNode.leftChildren;
            } else if (currentNode.key.compareTo(key) > 0) {
                currentNode = currentNode.rightChildren;
            } else {
                return currentNode.value;
            }
        }
        return null;
    }

    /**
     * Strict inserting element in tree
     *
     * @param key   key for ordering
     * @param value value for storing
     */
    @Override
    public void strictAdd(K key, V value) {
        Node currentNode = root, parent = root;
        while (currentNode != null) {
            parent = currentNode;
            if (currentNode.key.compareTo(key) < 0) {
                currentNode = currentNode.leftChildren;
            } else {
                currentNode = currentNode.rightChildren;
            }
        }
        currentNode = new Node((K) SystemUtils.clone(key), (V) SystemUtils.clone(value));
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
     * Searching list's value by key
     *
     * @return true if element exists, false if doesn't
     */
    @Override
    public boolean contains(K key) {
        Node currentNode = root;
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

    /**
     * Searching list's value by value
     *
     * @return true if element exists, false if doesn't
     */
    @Override
    public boolean containsValue(V value) {
        return inOrder(root, value);
    }

    /**
     * Removing element with key
     *
     * @param key for key removing
     */
    @Override
    public void remove(K key) {
        Node currentNode = root, parent = root;
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
                    Node leftNode = currentNode.leftChildren;
                    Node rightNode = currentNode.rightChildren;
                    Node successor = findSuccessor(currentNode);
                    successor.leftChildren = leftNode;
                    successor.rightChildren = rightNode;
                }
            }
        }
    }

    /**
     * Removing element by value
     *
     * @param value value for removing
     */
    @Override
    public void removeValue(V value) {
        K indexForRemoving = remove(root, value);
        if (indexForRemoving != null) {
            remove(indexForRemoving);
        }
    }

    /**
     * Getting successor for deleting list with two children
     *
     * @param firstNode list for getting
     * @return successor
     */
    private Node findSuccessor(Node firstNode) {
        Node successor = firstNode;
        Node successorParent = firstNode;
        Node current = firstNode.rightChildren;
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

    private K remove(Node localRoot, V value) {
        if (localRoot != null) {
            K leftResult = remove(localRoot.leftChildren, value);
            if (leftResult != null) {
                return leftResult;
            }
            if (localRoot.value.equals(value)) {
                return localRoot.key;
            } else {
                return remove(localRoot.rightChildren, value);
            }
        } else {
            return null;
        }
    }

    private boolean inOrder(Node localRoot, V value) {
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

    //tree's bypassing (tree's traversals)

    /**
     * Symmetric traversal
     *
     * @param localRoot node for bypassing
     * @param function  function fro node manipulation during bypassing
     */
    private void inOrder(Node localRoot, BiConsumer<K, V> function) {
        if (localRoot != null) {
            inOrder(localRoot.leftChildren, function);
            function.accept(localRoot.key, localRoot.value);
            inOrder(localRoot.rightChildren, function);
        }
    }

    /**
     * Forward traversal
     *
     * @param localRoot node for bypassing
     * @param function  function fro node manipulation during bypassing
     */
    private void fOrder(Node localRoot, BiConsumer<K, V> function) {
        if (localRoot != null) {
            function.accept(localRoot.key, localRoot.value);
            fOrder(localRoot.leftChildren, function);
            fOrder(localRoot.rightChildren, function);
        }
    }

    /**
     * Backward traversal
     *
     * @param localRoot node for bypassing
     * @param function  function fro node manipulation during bypassing
     */
    private void bOrder(Node localRoot, BiConsumer<K, V> function) {
        if (localRoot != null) {
            bOrder(localRoot.leftChildren, function);
            bOrder(localRoot.rightChildren, function);
            function.accept(localRoot.key, localRoot.value);
        }
    }
}
