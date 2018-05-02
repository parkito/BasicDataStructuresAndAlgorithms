package ru.siksmfp.basic.structure.tree.rb;

import ru.siksmfp.basic.structure.api.TreeStructure;
import ru.siksmfp.basic.structure.utils.SystemUtils;

/**
 * @author Artem Karnov @date 3/8/2018.
 * @email artem.karnov@t-systems.com
 */
// TODO: 5/1/2018 rewrite this structure
@Deprecated
public class RedBlackTree<K extends Comparable<K>, V> implements TreeStructure<K, V> {
    //    Rebalance
    //
    //    Black aunt - rotation
    //    Red aunt - color flip
    //
    //    Result of rotation
    //
    //        Black
    //    Red       Red
    //
    //    Result of color flip
    //
    //          Red
    //    Black     Black
    //
    //
    //    Rotations
    //
    //    Right                                Left
    //                3    --->     2                 1       --->        2
    //              2            1    3                 2              1     3
    //            1                                       3
    //
    //
    //   Left-right                            Right-left
    //
    //                5   --->     4                3      --->       4
    //              3            3   5                5            3     5
    //                4                             4
    //
    //
    //    Color flip
    //
    //            Black        <-->           Red
    //        Red      Red              Black     Black
    //    Red                        Red
    //

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
        Node node = new Node(key, value);
        if (root == null) {
            root = node;
            root.parent = null;
            root.isRed = false;
        } else {
            add(root, node);
        }
        size++;
    }

    @Override
    public void strictAdd(K key, V value) {
        Node node = new Node(SystemUtils.clone(key), SystemUtils.clone(value));
        if (root == null) {
            root = node;
            root.parent = null;
            root.isRed = false;
        } else {
            add(root, node);
        }
        size++;
    }

    @Override
    public V get(K key) {
        Node node = root;
        while (node != null) {
            if (node.key.compareTo(key) == 0) {
                return node.value;
            } else if (node.key.compareTo(key) > 0) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        Node node = root;
        while (node != null) {
            if (node.key.compareTo(key) == 0) {
                return true;
            } else if (node.key.compareTo(key) > 0) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return inOrder(root, value);
    }

    private boolean inOrder(Node localRoot, V value) {
        if (localRoot == null) return false;
        if (localRoot.value == value) return true;
        if (localRoot.value != null && localRoot.value.equals(value)) return true;

        return inOrder(localRoot.leftChild, value) || inOrder(localRoot.rightChild, value);
    }

    @Override
    public void remove(K key) {
        Node node = getNodeByKey(key);
        if (node != null) {
            deleteNode(node);
        }
    }

    @Override
    public void removeValue(V value) {
        Node node = getNodeByValue(root, value);
        if (node != null) {
            deleteNode(node);
        }
    }

    @Override
    public int height() {
        if (root == null) {
            return 0;
        } else {
            return height(root) - 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public int blackHeight() {
        return blackNodes(root);
    }

    // 1) Find place for inserting (binary tree rules)
    // 2) Insert red node
    // 3) Do balancing
    //      1) If uncle is red
    //       |---1) Do color flip of parent, uncle and grand father
    //       |---2) Do color flip of grand father relative until root
    //       2) If uncle is black
    //        |---1) Do rotation
    //        |    |---1) Depends on situation we can do
    //        |         |---1) Right rotation
    //        |         |---2) Left rotation
    //        |         |---3) Left-right rotation
    //        |         |---4) Right-left rotation
    //        |---2) Do color flip
    private void add(Node root, Node node) {
        if (node.key.compareTo(root.key) > 0) {
            if (root.rightChild == null) {
                root.rightChild = node;
                node.parent = root;
                node.isLeftChild = false;
            } else {
                add(root.rightChild, node);
            }
        } else if (node.key.compareTo(root.key) < 0) {
            if (root.leftChild == null) {
                root.leftChild = node;
                node.parent = root;
                node.isLeftChild = true;
            } else {
                add(root.leftChild, node);
            }
        } else {
            //If node with key already exist we just update value
            root.value = node.value;
        }
        balanceTree(node);
    }

    private void balanceTree(Node node) {
        if (node != root) {
            if (node.isRed && node.parent.isRed) {
                correctTree(node);
            }
            balanceTree(node.parent);
        }
    }

    private void correctTree(Node node) {
        //left subtree after grand father
        if (node.parent.isLeftChild) {
            // Right uncle is null or grand father is black
            if (node.parent.parent.rightChild == null || !node.parent.parent.isRed) {
                rotate(node);
            }
            //Color flip around grand father
            if (node.parent.parent != null) {
                node.parent.parent.rightChild.isRed = false;
                node.parent.parent.isRed = true;
                node.parent.isRed = false;
            }
            //right subtree after grand father
        } else {
            // Left uncle is null or grand father is black
            if (node.parent.parent.leftChild == null || !node.parent.parent.isRed) {
                rotate(node);
            }
            //Color flip around grand father
            if (node.parent.parent != null) {
                node.parent.parent.leftChild.isRed = false;
                node.parent.parent.isRed = true;
                node.parent.isRed = false;
            }
        }
    }

    private void rotate(Node node) {
        if (node.isLeftChild) {
            if (node.parent.isLeftChild) {                               //A
                rightRotation(node.parent.parent);                          //B
                node.isRed = true;                                             //C
                node.parent.isRed = false;
                if (node.parent.rightChild != null) {
                    node.parent.rightChild.isRed = true;
                }
            } else {                                                           //A
                rightLeftRotation(node.parent.parent);                      //B
                node.isRed = false;                                            //C
                node.rightChild.isRed = true;
                node.leftChild.isRed = true;
            }
        } else {
            if (!node.parent.isLeftChild) {                                       //A
                leftRotation(node.parent.parent);                              //B
                node.isRed = true;                                          //C
                node.parent.isRed = false;
                if (node.parent.leftChild != null) {
                    node.parent.leftChild.isRed = true;
                }
            } else {
                leftRightRotation(node.parent.parent);                            //A
                node.isRed = false;                                                   //B
                node.rightChild.isRed = true;                                   //C
                node.leftChild.isRed = true;
            }
        }
    }

    private void leftRotation(Node node) {
        Node temp = node.rightChild;
        node.rightChild = temp.leftChild;
        if (node.rightChild != null) {
            node.rightChild.parent = node;
            node.rightChild.isLeftChild = false;
        }
        if (node.parent == null) {
            //root
            root = temp;
            temp.parent = null;
        } else {
            temp.parent = node.parent;
            if (node.isLeftChild) {
                temp.isLeftChild = true;
                temp.parent.leftChild = temp;
            } else {
                temp.isLeftChild = false;
                temp.parent.rightChild = temp;
            }
        }
        temp.leftChild = node;
        node.isLeftChild = true;
        node.parent = temp;
    }

    private void rightRotation(Node node) {
        Node temp = node.leftChild;
        node.leftChild = temp.rightChild;
        if (node.leftChild != null) {
            node.leftChild.parent = node;
            node.rightChild.isLeftChild = true;
        }
        if (node.parent == null) {
            //root
            root = temp;
            temp.parent = null;
        } else {
            temp.parent = node.parent;
            if (!node.isLeftChild) {
                temp.isLeftChild = false;
                temp.parent.rightChild = temp;
            } else {
                temp.isLeftChild = true;
                temp.parent.leftChild = temp;
            }
        }
        temp.rightChild = node;
        node.isLeftChild = false;
        node.parent = temp;
    }

    private void leftRightRotation(Node node) {
        leftRotation(node.leftChild);
        rightRotation(node);
    }

    private void rightLeftRotation(Node node) {
        rightRotation(node.rightChild);
        leftRotation(node);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.leftChild) + 1;
            int rightHeight = height(node.rightChild) + 1;
            if (leftHeight > rightHeight) {
                return leftHeight;
            } else {
                return rightHeight;
            }
        }
    }

    private int blackNodes(Node node) {
        if (node == null) {
            return 1;
        } else {
            int rightBlackNodes = blackNodes(node.rightChild);
            int leftBlackNodes = blackNodes(node.leftChild);
            if (rightBlackNodes != leftBlackNodes) {
                throw new IllegalStateException("Tree isn't balanced");
            }

            if (!node.isRed) {
                leftBlackNodes++;
            }
            return leftBlackNodes;
        }
    }

    private Node getNodeByKey(K key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (key.compareTo(currentNode.key) < 0) {
                currentNode = currentNode.leftChild;
            } else if (key.compareTo(currentNode.key) > 0) {
                currentNode = currentNode.rightChild;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    private Node getNodeByValue(Node localRoot, V value) {
        if (localRoot != null) {
            if (localRoot.value.equals(value)) {
                return localRoot;
            }

            Node leftResult = getNodeByValue(localRoot.leftChild, value);
            if (leftResult != null) {
                return leftResult;
            }

            return getNodeByValue(localRoot.rightChild, value);
        } else {
            return null;
        }
    }

    /**
     * Getting successor for deleting list with two children
     *
     * @param node list for getting
     * @return successor
     */
    private Node findSuccessor(Node node) {
        if (node.rightChild != null) {
            return treeMin(node.rightChild);
        }
        Node parentNode = node.parent;
        while (parentNode != null && !node.isLeftChild) {
            node = parentNode;
            parentNode = parentNode.parent;
        }
        return parentNode;
    }

    private Node treeMin(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    /**
     * We look for successor, replace current element with it
     * and do tree rebalancing start form successor's old position
     *
     * @param node - node for deletion
     */
    private void deleteNode(Node node) {
        Node successor;
        if (node.leftChild == null || node.rightChild == null) {
            successor = node;
        } else {
            successor = findSuccessor(node);
        }

        Node successorChild;
        if (successor.leftChild != null) {
            successorChild = successor.leftChild;
        } else {
            successorChild = successor.rightChild;
        }

        if (successorChild != null) {
            successorChild.parent = successor.parent;
        }

        if (successor.parent == null) {
            root = successorChild;
        } else if (successor.isLeftChild) {
            successor.parent.leftChild = successorChild;
        } else {
            successor.parent.rightChild = successorChild;
        }

        if (successor != node) {
            node.key = successor.key;
            node.value = successor.value;
        }

        if (successorChild != null && !successor.isRed) {
            correctDeletion(successorChild);
        }

        size--;
    }

    /**
     * We bypass tree from down to up.
     * After each step we can have 4 cases of rebalancing
     *
     * @param node
     */
    private void correctDeletion(Node node) {
        while (node != root || !node.isRed) {
            Node sibling;
            if (node.isLeftChild) {
                sibling = node.parent.rightChild;
                // Case 1: node's sibling is red
                if (sibling.isRed) {
                    sibling.isRed = false;
                    node.parent.isRed = true;
                    leftRotation(node.parent);
                    sibling = node.parent.rightChild;
                }
                //  Case 2: node's sibling is black, and both of sibling's children are black
                if (!sibling.leftChild.isRed && !sibling.rightChild.isRed) {
                    sibling.isRed = true;
                    node = node.parent;
                    //  Case 3: node's sibling is black, his left child is red, and his right child is black
                } else if (!sibling.rightChild.isRed) {
                    sibling.leftChild.isRed = false;
                    sibling.isRed = true;
                    rightRotation(sibling);
                    sibling = node.parent.rightChild;
                }
                // Case 4: node's sibling is black, and his right child is red
                sibling.isRed = node.parent.isRed;
                node.parent.isRed = false;
                sibling.rightChild.isRed = false;
                leftRotation(node.parent);
                node = root;
            } else {
                if (node == node.parent.rightChild) {
                    sibling = node.parent.leftChild;
                    // Case 1: node's sibling is red
                    if (sibling.isRed) {
                        sibling.isRed = false;
                        node.parent.isRed = true;
                        rightRotation(node.parent);
                        sibling = node.parent.leftChild;
                    }
                    //  Case 2: node's sibling is black, and both of sibling's children are black
                    if (!sibling.rightChild.isRed && !sibling.leftChild.isRed) {
                        sibling.isRed = true;
                        node = node.parent;
                        //  Case 3: node's sibling is black, his left child is red, and his right child is black
                    } else if (!sibling.leftChild.isRed) {
                        sibling.rightChild.isRed = false;
                        sibling.isRed = true;
                        leftRotation(sibling);
                        sibling = node.parent.leftChild;
                    }
                    // Case 4: node's sibling is black, and his right child is red
                    sibling.isRed = node.parent.isRed;
                    node.parent.isRed = false;
                    sibling.leftChild.isRed = false;
                    rightRotation(node.parent);
                    node = root;
                }
            }
        }
        node.isRed = false;
    }
}
