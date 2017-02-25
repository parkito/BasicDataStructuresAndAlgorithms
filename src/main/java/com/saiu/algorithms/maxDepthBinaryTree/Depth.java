package com.saiu.algorithms.maxDepthBinaryTree;

import com.saiu.dataStructures.doubleSearchTree.TreeList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 25.02.17.
 *         artem.karnov@t-systems.com
 */

/**
 * Calculation max depth of binary search tree
 * if tree has only root --> max depth = 1
 * if tree has only root and left and right children --> max depth = 2
 * and so on
 */
public class Depth {
    private List<Integer> globalCounter = new ArrayList<>();

    public int getMaxDepth(TreeList<Integer> tree) {
        finder(tree, 0);
        System.out.println(globalCounter);
        return globalCounter.stream().max(Integer::compareTo).get();
    }

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
