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
    private class Node {
        private K key;
        private V value;
        private Node leftChildren;
        private Node rightChildren;
        private Node parent;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.rightChildren = null;
            this.leftChildren = null;
        }

        public String toString() {
            String leftChildrenKey = leftChildren == null ? "null" : leftChildren.key == null ? "null" : leftChildren.key.toString();
            String leftChildrenValue = leftChildren == null ? "null" : leftChildren.value == null ? "null" : leftChildren.value.toString();
            String rightChildrenKey = rightChildren == null ? "null" : rightChildren.key == null ? "null" : rightChildren.key.toString();
            String rightChildrenValue = rightChildren == null ? "null" : rightChildren.value == null ? "null" : rightChildren.value.toString();

            return "Node{key " + key + ", value " + value
                    + ", left child (" + leftChildrenKey + ";" + leftChildrenValue + ")"
                    + "; right child (" + rightChildrenKey + ";" + rightChildrenValue + ") }";
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
        currentNode.parent = parent;
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
        Node result = getNode(key);
        return result == null ? null : result.value;
    }

    private Node getNode(K key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.key.compareTo(key) < 0) {
                currentNode = currentNode.leftChildren;
            } else if (currentNode.key.compareTo(key) > 0) {
                currentNode = currentNode.rightChildren;
            } else {
                return currentNode;
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
        currentNode.parent = parent;
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
    // TODO: 3/11/2018 improve it
    @Override
    public void remove(K key) {
        Node nodeForDeleting = getNode(key);
        if (nodeForDeleting == null) {
            return;
        }
        if (nodeForDeleting.parent != null) {
            if (nodeForDeleting.parent.leftChildren != null && nodeForDeleting.parent.leftChildren.key.equals(key)) {
                nodeForDeleting = nodeForDeleting.parent.leftChildren;
            } else if (nodeForDeleting.parent.rightChildren != null && nodeForDeleting.parent.rightChildren.key.equals(key)) {
                nodeForDeleting = nodeForDeleting.parent.rightChildren;
            }
        }
        if (nodeForDeleting != null)
            removeNode(nodeForDeleting);
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

    @Override
    public int height() {
        // TODO: 3/11/2018  
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void removeNode(Node node) {
        if (node.leftChildren == null && node.rightChildren == null) {
            removeChildrenNode(node);
        } else if (node.leftChildren == null) {
            if (node.key.compareTo(node.parent.key) < 0) {
                node.parent.leftChildren = node.rightChildren;
            } else {
                node.parent.rightChildren = node.rightChildren;
            }
            removeChildrenNode(node);
        } else if (node.rightChildren == null) {
            if (node.key.compareTo(node.parent.key) < 0) {
                node.parent.leftChildren = node.leftChildren;
            } else {
                node.parent.rightChildren = node.leftChildren;
            }
            removeChildrenNode(node);
        } else {
            Node leftNode = node.leftChildren;
            Node rightNode = node.rightChildren;
            Node successor = findSuccessor(node);
            successor.leftChildren = leftNode;
            successor.rightChildren = rightNode;
        }
        size--;
    }

    private void removeChildrenNode(Node node) {
        if (node.parent.leftChildren != null && node.parent.leftChildren.key.equals(node.key)) {
            node.parent.leftChildren = null;
        } else if (node.parent.rightChildren != null && node.parent.rightChildren.key.equals(node.key)) {
            node.parent.rightChildren = null;
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
        //todo simplify it
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
        if (localRoot == null) return false;
        if (localRoot.value == value) return true;
        if (localRoot.value != null && localRoot.value.equals(value)) return true;

        return inOrder(localRoot.leftChildren, value) || inOrder(localRoot.rightChildren, value);
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
