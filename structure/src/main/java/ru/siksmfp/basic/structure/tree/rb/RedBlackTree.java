package ru.siksmfp.basic.structure.tree.rb;

import ru.siksmfp.basic.structure.api.TreeStructure;

/**
 * @author Artem Karnov @date 3/8/2018.
 * @email artem.karnov@t-systems.com
 */
public class RedBlackTree<K extends Comparable<K>, V> implements TreeStructure<K, V> {
    /**
     * Model of node's tree
     */
    private class Node {
        private K key;
        private V value;
        private boolean isRed;
        private boolean isLeftChild;
        private Node parent;
        private Node leftChildren;
        private Node rightChildren;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.isRed = true;
            this.isLeftChild = false;
            this.parent = null;
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

    @Override
    public void add(K key, V value) {
        Node node = new Node(key, value);
        if (root == null) {
            root = node;
            root.parent = root;
            root.isRed = false;
        } else {
            add(root, node);
        }
        size++;
    }

    private void add(Node parent, Node node) {
        if (node.key.compareTo(parent.key) > 0) {
            if (parent.rightChildren == null) {
                parent.rightChildren = node;
                node.parent = parent;
                node.isLeftChild = false;
            } else {
                add(parent.rightChildren, node);
            }
        } else if (node.key.compareTo(parent.key) < 0) {
            if (parent.leftChildren == null) {
                parent.leftChildren = node;
                node.parent = parent;
                node.isLeftChild = true;
            } else {
                add(parent.leftChildren, node);
            }
        } else {
            parent.value = node.value;
        }
        balanceTree(node);
    }

    private void balanceTree(Node node) {
        if (!node.equals(root)) {
            if (node.isRed && node.parent.isRed) {
                correctTree(node);
            }
            balanceTree(node.parent);
        }
    }

    private void correctTree(Node node) {
        if (node.parent.isLeftChild) {
            if (node.parent.parent.rightChildren == null || !node.parent.parent.isRed) {
                rotate(node);
            }

            if (node.parent.parent != null) {
                node.parent.parent.rightChildren.isRed = false;
                node.parent.parent.isRed = true;
                node.parent.isRed = false;
            }
        } else {
            if (node.parent.parent.leftChildren == null || !node.parent.parent.isRed) {
                rotate(node);
            }

            if (node.parent.parent != null) {
                node.parent.parent.leftChildren.isRed = false;
                node.parent.parent.isRed = true;
                node.parent.isRed = false;
            }
        }
    }

    private void rotate(Node node) {
        if (node.isLeftChild) {
            if (node.parent.isLeftChild) {
                rightRotation(node.parent.parent);
                node.isRed = true;
                node.parent.isRed = false;
                if (node.parent.rightChildren != null) {
                    node.parent.rightChildren.isRed = true;
                }
            } else {
                rightLeftRotation(node.parent.parent);
                node.isRed = false;
                node.rightChildren.isRed = true;   //is needed?
                node.leftChildren.isRed = false;
            }
        } else {
            if (node.parent.isLeftChild) {
                leftRotation(node.parent.parent);
                node.isRed = true;
                node.parent.isRed = false;
                if (node.parent.leftChildren != null) {
                    node.parent.leftChildren.isRed = true;
                }
            } else {
                leftRightRotation(node.parent.parent);
                node.isRed = false;
                node.rightChildren.isRed = true;   //is needed?
                node.leftChildren.isRed = false;
            }
        }
    }

    private void leftRotation(Node node) {
        Node temp = node.rightChildren;
        node.rightChildren = temp.leftChildren;
        if (node.rightChildren != null) {
            node.rightChildren.parent = node;
            node.rightChildren.isLeftChild = false;
        }
        if (node.parent == null) {
            //root
            root = temp;
            temp.parent = null;
        }else {
            temp.parent = node.parent;
            if (node.isLeftChild) {
                temp.isLeftChild = true;
                temp.parent.leftChildren = temp;
            }else {
                temp.isLeftChild = false;
                temp.parent.rightChildren = temp;
            }
            temp.leftChildren = node;
            node.isLeftChild = true;
            node.parent = temp;
        }
    }

    private void leftRightRotation(Node parent) {

    }

    private void rightLeftRotation(Node parent) {

    }

    private void rightRotation(Node parent) {

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
    public int size() {
        return 0;
    }
}
