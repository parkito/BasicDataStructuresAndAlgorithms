package ru.siksmfp.basic.structure.tree.doubled.seacrh.tree;

import org.junit.Assert;
import org.junit.Test;
import ru.siksmfp.basic.structure.api.TreeStructure;

/**
 * @author Artem Karnov @date 2/21/2018.
 * @email artem.karnov@t-systems.com
 */
public class SearchTreeTest {

    @Test
    public void firstTest() {
        TreeStructure<Integer, String> tree = new SearchTree<>();
        int firstKey = 1;
        int secondKey = 2;
        int thirdKey = 3;

        String firstValue = "1";
        String secondValue = "2";
        String thirdValue = "3";

        tree.add(firstKey, firstValue);
        tree.add(secondKey, secondValue);
        tree.add(thirdKey, thirdValue);

        Assert.assertNotNull(firstValue, tree.get(firstKey));
        Assert.assertNotNull(secondValue, tree.get(secondKey));
        Assert.assertNotNull(thirdValue, tree.get(thirdKey));
    }

}