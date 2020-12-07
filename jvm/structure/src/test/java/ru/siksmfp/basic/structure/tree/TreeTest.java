package ru.siksmfp.basic.structure.tree;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.siksmfp.basic.structure.api.TreeStructure;

import java.util.Random;

/**
 * @author Artem Karnov @date 2/21/2018.
 * @email artem.karnov@t-systems.com
 */
@Ignore
public class TreeTest {
    private static final int FIRST_KEY = 1;
    private static final int SECOND_KEY = 2;
    private static final int THIRD_KEY = 3;
    private static final int FOURTH_KEY = 4;

    private static final String FIRST_VALUE = "1";
    private static final String SECOND_VALUE = "2";
    private static final String THIRD_VALUE = "3";
    private static final String FOURTH_VALUE = "4";

    private static final int BIG_TREE_SIZE = 10000;
    private static final double INFELICITY = 0.001;

    protected TreeStructure<Integer, String> tree;
    protected TreeStructure<Integer, InnerMutableClass> iTree;

    public class InnerMutableClass {
        String stringField;
        Double doubleField;

        public InnerMutableClass(String stringField, Double doubleField) {
            this.stringField = stringField;
            this.doubleField = doubleField;
        }

        public String getStringField() {
            return stringField;
        }

        public void setStringField(String stringField) {
            this.stringField = stringField;
        }

        public Double getDoubleField() {
            return doubleField;
        }

        public void setDoubleField(Double doubleField) {
            this.doubleField = doubleField;
        }

        @Override
        public String toString() {
            return "InnerMutableClass{" +
                    "stringField='" + stringField + '\'' +
                    ", doubleField=" + doubleField +
                    '}';
        }
    }

    @Test
    public void add() {
        tree.add(FIRST_KEY, FIRST_VALUE);
        tree.add(SECOND_KEY, SECOND_VALUE);
        tree.add(THIRD_KEY, THIRD_VALUE);

        Assert.assertNotNull(FIRST_VALUE, tree.get(FIRST_KEY));
        Assert.assertNotNull(SECOND_VALUE, tree.get(SECOND_KEY));
        Assert.assertNotNull(THIRD_VALUE, tree.get(THIRD_KEY));
    }

    @Test
    public void contains() {
        tree.add(FIRST_KEY, FIRST_VALUE);
        tree.add(SECOND_KEY, SECOND_VALUE);
        tree.add(THIRD_KEY, THIRD_VALUE);

        Assert.assertEquals(3, tree.size());
        Assert.assertTrue(tree.contains(FIRST_KEY));
        Assert.assertTrue(tree.contains(SECOND_KEY));
        Assert.assertTrue(tree.contains(THIRD_KEY));
        Assert.assertFalse(tree.contains(FOURTH_KEY));
    }

    @Test
    public void containsValue() {
        tree.add(FIRST_KEY, FIRST_VALUE);
        tree.add(SECOND_KEY, SECOND_VALUE);
        tree.add(THIRD_KEY, THIRD_VALUE);

        Assert.assertEquals(3, tree.size());
        Assert.assertTrue(tree.containsValue(FIRST_VALUE));
        Assert.assertTrue(tree.containsValue(SECOND_VALUE));
        Assert.assertTrue(tree.containsValue(THIRD_VALUE));
        Assert.assertFalse(tree.containsValue(FOURTH_VALUE));
    }

    @Test
    public void removeByKey() {
        tree.add(FIRST_KEY, FIRST_VALUE);
        tree.add(SECOND_KEY, SECOND_VALUE);
        tree.add(THIRD_KEY, THIRD_VALUE);

        Assert.assertEquals(3, tree.size());

        tree.remove(THIRD_KEY);

        Assert.assertEquals(2, tree.size());
        Assert.assertTrue(tree.containsValue(FIRST_VALUE));
        Assert.assertTrue(tree.containsValue(SECOND_VALUE));
        Assert.assertFalse(tree.containsValue(THIRD_VALUE));
        Assert.assertFalse(tree.containsValue(FOURTH_VALUE));
    }

    @Test
    public void removeAllElementsAscending() {
        for (int i = 0; i < BIG_TREE_SIZE; i++) {
            tree.add(i, String.valueOf(i));
        }

        randomRemoveTreeCheck(tree, BIG_TREE_SIZE, BIG_TREE_SIZE);
    }

    @Test
    public void removeAllElementsDescending() {
        for (int i = BIG_TREE_SIZE; i > 0; i--) {
            tree.add(i, String.valueOf(i));
        }

        randomRemoveTreeCheck(tree, BIG_TREE_SIZE, BIG_TREE_SIZE);
    }

    @Test
    public void removeAllElementsRandom() {
        Random random = new Random();

        int treeSize = BIG_TREE_SIZE, actualSize = 0;
        for (int i = treeSize; i > 0; i--) {
            int rand = random.nextInt(treeSize);
            if (!tree.contains(rand)) {
                actualSize++;
            }
            tree.add(rand, String.valueOf(rand));
        }

        randomRemoveTreeCheck(tree, treeSize, actualSize);
    }

    @Test
    public void removeFirst() {
        tree.add(FIRST_KEY, FIRST_VALUE);
        tree.add(SECOND_KEY, SECOND_VALUE);

        tree.remove(SECOND_KEY);

        Assert.assertEquals(1, tree.size());
        Assert.assertTrue(tree.containsValue(FIRST_VALUE));

        tree.remove(FIRST_KEY);

        Assert.assertEquals(0, tree.size());
    }

    @Test
    public void removeValue() {
        tree.add(FIRST_KEY, FIRST_VALUE);
        tree.add(SECOND_KEY, SECOND_VALUE);
        tree.add(THIRD_KEY, THIRD_VALUE);

        tree.removeValue(SECOND_VALUE);

        Assert.assertEquals(2, tree.size());
        Assert.assertTrue(tree.containsValue(FIRST_VALUE));
        Assert.assertFalse(tree.containsValue(SECOND_VALUE));
        Assert.assertTrue(tree.containsValue(THIRD_VALUE));
    }

    @Test
    public void strictAdd() {
        String stringValue1 = "Value1";
        String stringValue2 = "Value2";
        String stringValue3 = "Value3";
        Double doubleValue1 = 1.0;
        Double doubleValue2 = 2.0;
        Double doubleValue3 = 3.0;

        InnerMutableClass innerMutableClass1 = new InnerMutableClass(stringValue1, doubleValue1);
        InnerMutableClass innerMutableClass2 = new InnerMutableClass(stringValue2, doubleValue2);

        iTree.add(FIRST_KEY, innerMutableClass1);
        iTree.strictAdd(SECOND_KEY, innerMutableClass2);

        innerMutableClass1.setStringField(stringValue3);
        innerMutableClass1.setDoubleField(doubleValue3);

        innerMutableClass2.setStringField(stringValue3);
        innerMutableClass2.setDoubleField(doubleValue3);

        Assert.assertEquals(2, iTree.size());
        Assert.assertEquals(stringValue3, iTree.get(FIRST_KEY).getStringField());
        Assert.assertEquals(doubleValue3, iTree.get(FIRST_KEY).getDoubleField(), INFELICITY);
        Assert.assertEquals(stringValue2, iTree.get(SECOND_KEY).getStringField());
        Assert.assertEquals(doubleValue2, iTree.get(SECOND_KEY).getDoubleField(), INFELICITY);
    }

    private void randomRemoveTreeCheck(TreeStructure<Integer, String> tree, int treeSize, int treeCounter) {
        Random random = new Random();
        for (int i = treeSize; i > 0; i--) {
            int randomPosition = random.nextInt(treeSize);
            if (tree.containsValue(String.valueOf(randomPosition))) {
                treeCounter--;
            }
            tree.remove(randomPosition);
            if (treeCounter!=tree.size()){
                System.out.println(tree);
            }
            Assert.assertEquals(treeCounter, tree.size());
            Assert.assertFalse(tree.containsValue(String.valueOf(randomPosition)));
        }
    }
}