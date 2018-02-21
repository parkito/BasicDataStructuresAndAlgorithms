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

    @Test
    public void secondTest() {
        TreeStructure<Integer, String> tree = new SearchTree<>();
        int firstKey = 1;
        int secondKey = 2;
        int thirdKey = 3;
        int fourthKey = 4;

        String firstValue = "1";
        String secondValue = "2";
        String thirdValue = "3";

        tree.add(firstKey, firstValue);
        tree.add(secondKey, secondValue);
        tree.add(thirdKey, thirdValue);

        Assert.assertTrue(tree.contains(firstKey));
        Assert.assertTrue(tree.contains(secondKey));
        Assert.assertTrue(tree.contains(thirdKey));
        Assert.assertFalse(tree.contains(fourthKey));
    }

    @Test
    public void thirdTest() {
        TreeStructure<Integer, String> tree = new SearchTree<>();
        int firstKey = 1;
        int secondKey = 2;
        int thirdKey = 3;

        String firstValue = "1";
        String secondValue = "2";
        String thirdValue = "3";
        String fourthValue = "4";

        tree.add(firstKey, firstValue);
        tree.add(secondKey, secondValue);
        tree.add(thirdKey, thirdValue);

        Assert.assertTrue(tree.containsValue(firstValue));
        Assert.assertTrue(tree.containsValue(secondValue));
        Assert.assertTrue(tree.containsValue(thirdValue));
        Assert.assertFalse(tree.containsValue(fourthValue));
    }

    @Test
    public void fourthTest() {
        TreeStructure<Integer, String> tree = new SearchTree<>();
        int firstKey = 1;
        int secondKey = 2;
        int thirdKey = 3;

        String firstValue = "1";
        String secondValue = "2";
        String thirdValue = "3";
        String fourthValue = "4";

        tree.add(firstKey, firstValue);
        tree.add(secondKey, secondValue);
        tree.add(thirdKey, thirdValue);

        tree.remove(thirdKey);

        Assert.assertTrue(tree.containsValue(firstValue));
        Assert.assertTrue(tree.containsValue(secondValue));
        Assert.assertFalse(tree.containsValue(thirdValue));
        Assert.assertFalse(tree.containsValue(fourthValue));
    }

}