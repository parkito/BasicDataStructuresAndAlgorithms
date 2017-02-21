package com.saiu;

import com.saiu.dataStructures.deck.Deck;

/**
 * Created by Artyom Karnov on 15.11.16.
 * artyom-karnov@yandex.ru
 **/
public class Main {
    public static void main(String[] args) {
//        int size = 10;
//        FixedArray<Integer> com.saiu.dataStructures.fixedArray = new FixedArray<Integer>(size);
//        for (int i = 0; i < size; i++) {
//            com.saiu.dataStructures.fixedArray.add(Integer.valueOf(i), i);
//            System.out.println(com.saiu.dataStructures.fixedArray.get(i));
//        }
//        LinkedList<Integer> linkedList = new LinkedList();
//        linkedList.add(0);
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.displayAll();
//        System.out.println();
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.get(3));
//        System.out.println(linkedList.get(4));
//        linkedList.removeFirst();
//        linkedList.removeFirst();
//        linkedList.removeFirst();
//        linkedList.removeFirst();
//        linkedList.removeLast();
//        linkedList.removeLast();
//        linkedList.removeLast();
//        linkedList.removeLast();
//        linkedList.removeLast();
//
//        linkedList.remove(3);
//
//        System.out.println();
//        linkedList.displayAll();

//        DoubleLinkedList<Integer> com.saiu.dataStructures.doubleLinkedList = new DoubleLinkedList<Integer>();
//        com.saiu.dataStructures.doubleLinkedList.add(0);
//        com.saiu.dataStructures.doubleLinkedList.add(1);
//        com.saiu.dataStructures.doubleLinkedList.add(2);
//        com.saiu.dataStructures.doubleLinkedList.add(3);
//        com.saiu.dataStructures.doubleLinkedList.add(4);
//        com.saiu.dataStructures.doubleLinkedList.displayFromStarch();
//        System.out.println();
//        com.saiu.dataStructures.doubleLinkedList.displayFromEnd();
//        Deck<Integer> com.saiu.dataStructures.deck = new Deck<Integer>();
//        com.saiu.dataStructures.deck.push(1);
//        com.saiu.dataStructures.deck.push(2);
//        System.out.println(com.saiu.dataStructures.deck.pop());
//        System.out.println(com.saiu.dataStructures.deck.pop());
//        Random  tree
//        Random random = new Random();
//        SearchTree<Integer> tree = new SearchTree<Integer>();
//        for (int i = 0; i < 12; i++) {
//            tree.add(random.nextInt(10), null);
//        }
//        tree.showTree();
//          My tree
//        SearchTree<Integer> tree = new SearchTree<Integer>();
//        tree.add(7, 1);
//        tree.add(5, 2);
//        tree.add(15, 3);
//        tree.add(18, 4);
//        tree.add(20, 4);
//        tree.add(8, 5);
//        tree.add(2, 6);
//        tree.add(6, 7);
//        tree.add(16, 8);
//        tree.remove(15);
//        tree.add(100);
//        tree.showTree();
//        System.out.println(tree.find(7)); //1
//        System.out.println(tree.find(2)); //4
//        System.out.println(tree.find(10)); //null
//        tree.inOrderFullTraversal();
//        System.out.println();
//        tree.preOrderFullTraversal();
//        System.out.println();
//        tree.postOrderFullTraversal();
//        tree.displayTree();
//        Collection coll = new LinkedList();
        Deck<Integer> deck = new Deck<Integer>();
        deck.push(1);
        deck.push(2);
        deck.push(3);
        deck.push(4);

        System.out.println(deck.back());
        System.out.println(deck.back());
        System.out.println(deck.back());
        System.out.println(deck.back());
        System.out.println(deck.back());
    }
}
