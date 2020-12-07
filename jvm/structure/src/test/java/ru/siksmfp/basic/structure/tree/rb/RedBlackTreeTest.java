package ru.siksmfp.basic.structure.tree.rb;

import org.junit.Before;
import org.junit.Ignore;
import ru.siksmfp.basic.structure.tree.TreeTest;

/**
 * @author Artem Karnov @date 3/13/2018.
 * @email artem.karnov@t-systems.com
 */
@Ignore
public class RedBlackTreeTest extends TreeTest {

    @Before
    public void setUp() {
        tree = new RedBlackTree<>();
        iTree = new RedBlackTree<>();
    }
}