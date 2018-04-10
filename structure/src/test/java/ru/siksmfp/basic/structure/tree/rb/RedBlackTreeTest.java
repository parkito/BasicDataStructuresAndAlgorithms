package ru.siksmfp.basic.structure.tree.rb;

import org.junit.Before;
import ru.siksmfp.basic.structure.tree.TreeTest;

/**
 * @author Artem Karnov @date 3/13/2018.
 * @email artem.karnov@t-systems.com
 */
public class RedBlackTreeTest extends TreeTest {

    @Before
    public void setUp() {
        tree = new RedBlackTree<>();
    }
}