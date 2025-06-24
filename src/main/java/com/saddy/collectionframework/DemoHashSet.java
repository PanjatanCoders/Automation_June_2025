package com.saddy.collectionframework;

import java.util.HashSet;
import java.util.Iterator;

public class DemoHashSet {
    public static void main(String[] args) {
        demo1HashSet();
    }

    static void demo1HashSet() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(8);
        hashSet.add(1);
        System.out.println(hashSet);
        System.out.println(hashSet.size());
        System.out.println("--------------------------------------");
        for (int num : hashSet)
            System.out.println(num);
        System.out.println("--------------------------------------");
        Iterator itr = hashSet.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println("--------------------------------------");

    }
}
