package ru.siksmfp.basic.algorithm.exers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.siksmfp.basic.structure.model.Node;

public class NodeReversalTest
{

    @Test
    public void simpleTest()
    {
        Node<Integer> node5 = new Node<>(5, null);
        Node<Integer> node4 = new Node<>(4, node5);
        Node<Integer> node3 = new Node<>(3, node4);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> node1 = new Node<>(1, node2);

        Node<Integer> cur = node1;
        for (int i = 1; i <= 5; i++)
        {
            assertEquals(i, cur.content.intValue());
            cur = cur.next;
        }

        cur = NodeReversal.reverse(node1);

        for (int i = 5; i >= 1; i--)
        {
            assertEquals(i, cur.content.intValue());
            cur = cur.next;
        }
    }

    @Test
    public void singleNodeTest()
    {
        Node<Integer> node1 = new Node<>(1, null);

        assertEquals(1, node1.content.intValue());

        Node<Integer> cur = NodeReversal.reverse(node1);

        assertEquals(1, cur.content.intValue());
    }

    @Test
    public void twoNodesTest()
    {
        Node<Integer> node2 = new Node<>(2, null);
        Node<Integer> node1 = new Node<>(1, node2);

        Node<Integer> cur = node1;
        assertEquals(1, cur.content.intValue());
        cur = cur.next;
        assertEquals(2, cur.content.intValue());

        cur = NodeReversal.reverse(node1);

        assertEquals(2, cur.content.intValue());
        cur = cur.next;
        assertEquals(1, cur.content.intValue());
    }
}