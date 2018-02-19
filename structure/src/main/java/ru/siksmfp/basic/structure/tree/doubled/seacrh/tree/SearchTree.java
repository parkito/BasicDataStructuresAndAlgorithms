package ru.siksmfp.basic.structure.tree.doubled.seacrh.tree;

/**
 * @author Artem Karnov @date 08.12.16.
 * artem.karnov@t-systems.com
 **/
public class SearchTree<T extends Comparable<T>> {

    public class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> leftChildren;
        private Node<T> rightChildren;

        private Node(T data) {
            this.data = data;
            this.rightChildren = null;
            this.leftChildren = null;
        }

        private Node(T data, Node<T> leftChildren, Node<T> rightChildren) {
            this.data = data;
            this.rightChildren = leftChildren;
            this.leftChildren = rightChildren;
        }

        public String toString() {
            return "List{data " + data + ", left child " + leftChildren + ", right child " + rightChildren + "}";
        }
    }

    private Node<T> root;
    private int size;

    public SearchTree() {
        root = null;
    }

    /**
     * Addition list after max element
     *
     * @param element element for adding
     */
    public void add(T element) {
        Node<T> currentNode = root, parent = root;
        while (currentNode != null) {
            parent = currentNode;
            if (currentNode.data.compareTo(element) < 0)
                currentNode = currentNode.leftChildren;
            else {
                currentNode = currentNode.rightChildren;
            }
        }
        currentNode = new Node<>(element);
        size++;
        if (parent != null) {
            if (parent.data.compareTo(element) < 0)
                parent.leftChildren = currentNode;
            else {
                parent.rightChildren = currentNode;
            }
        }
    }

    /**
     * Searching list's data by key
     *
     * @return list's data if element exists, null if doesn't
     */
    public boolean contains(T element) {
        Node<T> currentNode = root;
        while (currentNode != null) {
            if (currentNode.data.equals(element))
                return true;
            else if (currentNode.data.compareTo(element) < 0) {
                currentNode = currentNode.leftChildren;
            } else {
                currentNode = currentNode.rightChildren;
            }
        }
        return false;
    }

    /**
     * Removing element
     *
     * @param element for element removing
     */
    public void remove(T element) {
        Node<T> currentNode = root, parent = root;
        while (currentNode != null) {
            if (currentNode.data.equals(element)) {
                if (currentNode.leftChildren == null && currentNode.rightChildren == null) {
                    currentNode = null;
                } else if (currentNode.leftChildren == null) {
                    if (currentNode.data.compareTo(parent.data) < 0) {
                        parent.leftChildren = currentNode.rightChildren;
                    } else {
                        parent.rightChildren = currentNode.rightChildren;
                    }
                    currentNode = null;
                } else if (currentNode.rightChildren != null) {
                    if (currentNode.data.compareTo(parent.data) < 0) {
                        parent.leftChildren = currentNode.leftChildren;
                    } else {
                        parent.rightChildren = currentNode.leftChildren;
                    }
                    currentNode = null;
                } else {
                    Node<T> leftNode = currentNode.leftChildren;
                    Node<T> rightNode = currentNode.rightChildren;
                    Node<T> successor = findSuccessor(currentNode);
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
    private Node<T> findSuccessor(Node<T> firstNode) {
        Node<T> successor = firstNode;
        Node<T> successorParent = firstNode;
        Node<T> current = firstNode.rightChildren;
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

    /**
     * Getting mount of list children
     *
     * @param list list for researching
     * @return mount of children
     */
    private short childNodeNumber(Node list) {
        if (list.leftChildren == null && list.rightChildren == null) {
            return 0;
        }
        //if only one children (XOR)
        else if (list.leftChildren == null ^ list.rightChildren == null) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Tree traversal in order
     */
    public void inOrderFullTraversal() {
        inOrderTraversal(root);
    }

    /**
     * Tree traversal in pre order
     */
    public void preOrderFullTraversal() {
        preOrderTraversal(root);
    }

    /**
     * Tree traversal in post order
     */
    public void postOrderFullTraversal() {
        postOrderTraversal(root);
    }

    /**
     * Recurrent mechanism for in order tree traversal
     *
     * @param currentList local root
     */
    private void inOrderTraversal(Node currentList) {
        if (currentList != null) {
            inOrderTraversal(currentList.leftChildren);
            System.out.println(currentList);
            inOrderTraversal(currentList.rightChildren);
        }
    }

    /**
     * Recurrent mechanism for pre order tree traversal
     *
     * @param currentList local root
     */
    private void preOrderTraversal(Node currentList) {
        if (currentList != null) {
            System.out.println(currentList);
            preOrderTraversal(currentList.leftChildren);
            preOrderTraversal(currentList.rightChildren);
        }
    }

    /**
     * Recurrent mechanism for post order tree traversal
     *
     * @param currentList local root
     */
    private void postOrderTraversal(Node currentList) {
        if (currentList != null) {
            postOrderTraversal(currentList.leftChildren);
            postOrderTraversal(currentList.rightChildren);
            System.out.println(currentList);
        }
    }
}