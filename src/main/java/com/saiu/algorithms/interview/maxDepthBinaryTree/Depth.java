package com.saiu.algorithms.interview.maxDepthBinaryTree;

import com.saiu.dataStructures.doubleSearchTree.TreeList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 25.02.17.
 * artem.karnov@t-systems.com
 */

/**
 * Calculation max depth of binary search tree
 * if tree has only root --> max depth = 1
 * if tree has only root and left and right children --> max depth = 2
 * and so on
 */
public class Depth {
    private List<Integer> globalCounter = new ArrayList<>();

    /**
     * Getting max depth of tree
     * @param tree tree data structure for calculation
     * @return max depth of tree
     */
    public int getMaxDepth(TreeList<Integer> tree) {
        finder(tree, 0);
        return globalCounter.stream().max(Integer::compareTo).get();
    }

    /**
     * Recursive method for tree traversal
     * @param list member of the tree
     * @param level level of this member
     */
    private void finder(TreeList<Integer> list, int level) {
        level++;
        if (list.getLeftChildren() != null)
            finder(list.getLeftChildren(), level);
        else globalCounter.add(level);

        if (list.getRightChildren() != null)
            finder(list.getRightChildren(), level);
        else globalCounter.add(level);
    }
}
