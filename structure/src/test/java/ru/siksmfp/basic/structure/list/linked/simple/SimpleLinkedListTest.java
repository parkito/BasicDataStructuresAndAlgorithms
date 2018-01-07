package ru.siksmfp.basic.structure.list.linked.simple;

import org.junit.Test;
import ru.siksmfp.basic.structure.exceptions.IncorrectIndexException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Artem Karnov @date 29.11.2016.
 * artem.karnov@t-systems.com
 **/
public class SimpleLinkedListTest {

    @Test
    public void add() throws Exception {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
        list.add(0);
        assertTrue(list.contains(0));
        assertTrue(list.size() > 0);
    }

    @Test(expected = IncorrectIndexException.class)
    public void get() throws Exception {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<Integer>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
        simpleLinkedList.add(4);
        assertEquals(1, (long) simpleLinkedList.get(0));
        assertEquals(4, (long) simpleLinkedList.get(3));
        simpleLinkedList.get(-1);
        simpleLinkedList.get(4);

    }


    @Test
    public void removeFirst() throws Exception {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<Integer>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
        simpleLinkedList.add(4);
        simpleLinkedList.removeFirst();
        assertFalse(simpleLinkedList.contains(1));
    }

    @Test
    public void removeLast() throws Exception {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<Integer>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
        simpleLinkedList.add(4);
        simpleLinkedList.removeLast();
        assertFalse(simpleLinkedList.contains(4));
    }

    @Test(expected = IncorrectIndexException.class)
    public void remove() throws Exception {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<Integer>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
        simpleLinkedList.add(4);
        simpleLinkedList.remove(2);
        assertFalse(simpleLinkedList.contains(3));
        simpleLinkedList.remove(-1);
        simpleLinkedList.remove(simpleLinkedList.size());
    }

    @Test
    public void incorrectRemoving() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.remove(1);
        System.out.println(simpleLinkedList);
    }

    @Test
    public void isEmpty() throws Exception {
        SimpleLinkedList<Integer> emptyList = new SimpleLinkedList<Integer>();
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
        list.add(1);
        assertTrue(emptyList.isEmpty());
        assertFalse(list.isEmpty());

    }

    @Test
    public void size() throws Exception {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<Integer>();
        assertEquals(0, simpleLinkedList.size());
        simpleLinkedList.add(48);
        simpleLinkedList.add(15);
        assertEquals(2, simpleLinkedList.size());
    }

    @Test
    public void contains() throws Exception {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<Integer>();
        simpleLinkedList.add(48);
        simpleLinkedList.add(15);
        simpleLinkedList.add(16);
        simpleLinkedList.add(23);
        simpleLinkedList.add(42);
        assertTrue(simpleLinkedList.contains(16));
        assertFalse(simpleLinkedList.contains(Integer.MAX_VALUE));
    }

}