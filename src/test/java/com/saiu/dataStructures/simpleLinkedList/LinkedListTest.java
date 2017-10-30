package com.saiu.dataStructures.simpleLinkedList;


import com.saiu.dataStructures.exceptions.IncorrectIndexException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


/**
 * @author Artem Karnov @date 29.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class LinkedListTest {

    @Test
    public void add() throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0);
        assertTrue(list.contains(0));
        assertTrue(list.size() > 0);
    }

    @Test(expected = IncorrectIndexException.class)
    public void get() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertEquals(1, (long) linkedList.get(0));
        assertEquals(4, (long) linkedList.get(3));
        linkedList.get(-1);
        linkedList.get(4);

    }


    @Test
    public void removeFirst() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.removeFirst();
        assertFalse(linkedList.contains(1));
    }

    @Test
    public void removeLast() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.removeLast();
        assertFalse(linkedList.contains(4));
    }

    @Test(expected = IncorrectIndexException.class)
    public void remove() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.remove(2);
        assertFalse(linkedList.contains(3));
        linkedList.remove(-1);
        linkedList.remove(linkedList.size());
    }

    @Test
    public void isEmpty() throws Exception {
        LinkedList<Integer> emptyList = new LinkedList<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        assertTrue(emptyList.isEmpty());
        assertFalse(list.isEmpty());

    }

    @Test
    public void size() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        assertEquals(0, linkedList.size());
        linkedList.add(48);
        linkedList.add(15);
        assertEquals(2, linkedList.size());
    }

    @Test
    public void contains() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(48);
        linkedList.add(15);
        linkedList.add(16);
        linkedList.add(23);
        linkedList.add(42);
        assertTrue(linkedList.contains(16));
        assertFalse(linkedList.contains(Integer.MAX_VALUE));
    }

}