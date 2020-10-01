package ru.siksmfp.basic.structure.model;

public class Node<T>
{
    public T content;
    public Node<T> next;

    public Node(T content, Node<T> next)
    {
        this.content = content;
        this.next = next;
    }
}
