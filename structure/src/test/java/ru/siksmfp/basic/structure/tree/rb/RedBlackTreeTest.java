package ru.siksmfp.basic.structure.tree.rb;

import org.junit.Assert;
import org.junit.Test;
import ru.siksmfp.basic.structure.api.TreeStructure;

/**
 * @author Artem Karnov @date 3/13/2018.
 * @email artem.karnov@t-systems.com
 */
public class RedBlackTreeTest {
    private Integer firstKey = 1;
    private String firstValue = "1";
    private Integer secondKey = 2;
    private String secondValue = "2";
    private Integer thirdKey = 3;
    private String thirdValue = "3";


    @Test
    public void firstTest() {
        TreeStructure<Integer, String> tree = new RedBlackTree<>();
        tree.add(firstKey, firstValue);
        tree.add(secondKey, secondValue);
        tree.add(thirdKey, thirdValue);

        Assert.assertEquals(3, tree.size());
    }

}