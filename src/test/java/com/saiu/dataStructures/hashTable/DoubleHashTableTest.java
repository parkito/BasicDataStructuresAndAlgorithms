package com.saiu.dataStructures.hashTable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testSupport.TestUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Artem Karnov @date 22.02.2017.
 *         artem.karnov@t-systems.com
 */

public class DoubleHashTableTest {
    DoubleHashTable<String> hashTable;

    @Before
    public void setUp() {
        hashTable = new DoubleHashTable<String>(100);
    }

    @Test
    public void addAndGetOneElementTesting() {
        hashTable.add(1, "one");
        Assert.assertEquals("one", hashTable.getData(1));
        Assert.assertEquals("one", hashTable.delete(1));
        Assert.assertEquals(null, hashTable.delete(1));
        Assert.assertEquals(null, hashTable.delete(1000000000));

        hashTable.add(1, "one");
        hashTable.remove(1);
        Assert.assertEquals(null, hashTable.getData(1));

        hashTable.add(1, "one");
        Assert.assertEquals(1, hashTable.getDataKey("one"));
        hashTable.remove(1);
        Assert.assertEquals(-1, hashTable.getDataKey("one"));
    }

    @Test
    public void addAndGetElementsTest() {
        List<String> strings = TestUtils.getStringsOfNumbers(10, 30);
        for (int i = 1; i < 20; i++) {
            hashTable.add(i, strings.get(i));
        }

        Assert.assertEquals(-1, hashTable.getDataKey("232"));
    }

    // TODO: 23.02.2017 Implementation
    @Test
    public void isPrimeNumberTesting() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class doubleHashTableClass = Class.forName("com.saiu.dataStructures.hashTable.DoubleHashTable");
        Object object = doubleHashTableClass.getConstructor();
        Method method = doubleHashTableClass.getDeclaredMethod("isPrimeNumber", Integer.TYPE);
        method.setAccessible(true);
        Assert.assertEquals(true, method.invoke(object, 1));
        Assert.assertEquals(true, method.invoke(object, 3));
        Assert.assertEquals(true, method.invoke(object, 5));
        Assert.assertEquals(true, method.invoke(object, 7));
        Assert.assertEquals(true, method.invoke(object, 11));
        Assert.assertEquals(true, method.invoke(object, 13));
        Assert.assertEquals(true, method.invoke(object, 17));
        Assert.assertEquals(true, method.invoke(object, 17));
        Assert.assertEquals(true, method.invoke(object, 17));
        Assert.assertEquals(true, method.invoke(object, 17));
        Assert.assertEquals(true, method.invoke(object, 17));
    }
}