package com.saddy.collectionframework;

import java.util.ArrayList;
import java.util.Collections;

public class DemoArrayList {
    public static void main(String[] args) {
        day2ArrayList();
    }
    static void day2ArrayList() {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Banana");
        fruits.add("Guava");
        System.out.println(fruits);

        fruits.add(2, "PineApple");
        System.out.println(fruits);

        ArrayList<String> arrList = new ArrayList<>();
        arrList.addAll(fruits);
        System.out.println(arrList);

        Collections.addAll(fruits, "Cherry", "Date", "Mango", "Pear");
        System.out.println(fruits);
//        Iterator is used to loop though a data structure
//        Iterator iterator = fruits.iterator();
//        while (iterator.hasNext())
//            System.out.println(iterator.next());

        System.out.println("=========================================");
        System.out.println(fruits.remove("Orange"));
        fruits.removeIf( n -> n.equals("Date"));
        System.out.println(fruits);

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(5);
        nums.add(10);
        nums.add(14);
        nums.add(13);
//        remove the even numbers from this list
        System.out.println(nums);
        nums.removeIf(n -> n % 2 == 0);
        System.out.println(nums);

        System.out.println(fruits.subList(2, 4));
    }




    static void day1ArrayList() {
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
