package com.saddy.collectionframework;

import java.util.ArrayList;

public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();

        System.out.println(arrayList);
        arrayList.add(20);
        arrayList.add(20);
        arrayList.add(40);
        arrayList.add(12);
        arrayList.add(45);

        arrayList1.add("Java");
//        arrayList2.add(true);
        System.out.println(arrayList);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.get(arrayList.size()-1));

        arrayList.remove(0);
        System.out.println(arrayList);

        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList2.isEmpty());
        System.out.println("-------------------------------------");
//        traversing through the arrayList
        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println("Item at index " + i + " is: " + arrayList.get(i));
            System.out.println(String.format("Item at index %d is: %d", i, arrayList.get(i)));
        }
        System.out.println("-------------------------------------");
        for (int item : arrayList)
            System.out.println(item);
    }
}
