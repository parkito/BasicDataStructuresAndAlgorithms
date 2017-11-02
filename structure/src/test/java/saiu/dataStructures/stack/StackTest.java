package saiu.dataStructures.stack;

import com.saiu.dataStructures.exceptions.MistakenStackSize;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Artyom Karnov on 18.11.16.
 * artyom-karnov@yandex.ru
 **/
public class StackTest {
    Stack<Integer> deck;

    @Before
    public void setUp() throws Exception {
        deck = new Stack();
        deck.push(Integer.valueOf(0));
        deck.push(Integer.valueOf(1));
        deck.push(Integer.valueOf(2));
        deck.push(Integer.valueOf(3));
        deck.push(Integer.valueOf(4));
        deck.push(Integer.valueOf(5));
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(deck.size(), 6);
    }

    @Test
    public void sizeTestTwo() {
        Assert.assertNotEquals(deck.size(), -5);
    }

    @Test
    public void pushTestOne() {
        Assert.assertNotEquals(deck.pop(), Integer.valueOf(6));
    }

    @Test
    public void pushTestTwo() {
        deck.push(Integer.valueOf(100));
        Assert.assertEquals(deck.pop(), Integer.valueOf(100));
    }

    @Test
    public void popTestOne() {
        Assert.assertEquals(deck.pop(), Integer.valueOf(5));
        Assert.assertEquals(deck.pop(), Integer.valueOf(4));
        Assert.assertEquals(deck.pop(), Integer.valueOf(3));
        Assert.assertEquals(deck.pop(), Integer.valueOf(2));
        Assert.assertEquals(deck.pop(), Integer.valueOf(1));
        Assert.assertEquals(deck.pop(), Integer.valueOf(0));
    }

    @Test(expected = MistakenStackSize.class)
    public void popTestTwo() {
        deck.pop();
        deck.pop();
        deck.pop();
        deck.pop();
        deck.pop();
        deck.pop();
        deck.pop();
        deck.pop();
        deck.pop();
    }

    @Test
    public void containTestOne() {
        Assert.assertTrue(deck.contain(Integer.valueOf(3)));
    }

    @Test
    public void containTestTwo() {
        Assert.assertFalse(deck.contain(Integer.valueOf(33)));
    }

}