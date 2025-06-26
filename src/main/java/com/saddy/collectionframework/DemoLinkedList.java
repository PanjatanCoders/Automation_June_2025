package com.saddy.collectionframework;

import java.util.LinkedList;

public class DemoLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Apple");

        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
        linkedList.remove(1);
        System.out.println(linkedList);
    }
}
