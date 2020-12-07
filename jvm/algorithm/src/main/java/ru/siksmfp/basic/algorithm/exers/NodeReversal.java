package ru.siksmfp.basic.algorithm.exers;

import ru.siksmfp.basic.structure.model.Node;

public class NodeReversal
{
    public static <T> Node<T> reverse(Node<T> node)
    {
        Node<T> first = null;

        while (node != null)
        {
            Node<T> next = node.next;
            node.next = first;
            first = node;
            node = next;
        }

        return first;
    }
}


