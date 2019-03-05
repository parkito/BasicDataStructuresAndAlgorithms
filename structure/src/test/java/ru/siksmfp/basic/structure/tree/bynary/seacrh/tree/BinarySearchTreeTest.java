package ru.siksmfp.basic.structure.tree.bynary.seacrh.tree;

import org.junit.Before;
import org.junit.Ignore;
import ru.siksmfp.basic.structure.tree.TreeTest;
import ru.siksmfp.basic.structure.tree.rb.RedBlackTree;

/**
 * @author Artem Karnov @date 4/10/2018.
 * @email artem.karnov@t-systems.com
 */
@Ignore
public class BinarySearchTreeTest extends TreeTest {

    @Before
    public void setUp() {
        this.tree = new SearchTree<>();
        iTree = new SearchTree<>();
    }
}
