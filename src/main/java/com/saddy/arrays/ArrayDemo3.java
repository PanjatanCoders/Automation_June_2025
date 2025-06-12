package com.saddy.arrays;

public class ArrayDemo3 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 12, 30, 22, 40, 50};

        // Traverse the array using a for loop
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println("Element at index " + i + ": " + numbers[i]);
//        }

//        Advanced for loop (enhanced for loop)
//        for (int a : numbers) {
//            System.out.println("Element: " + a);
//        }
//
//        // Using a while loop
        int i = 0;
        while (i < numbers.length) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
            i++;
        }
//
        // Using a do-while loop
        i = 0;
        do {
            System.out.println("Element at index " + i + ": " + numbers[i]);
            i++;
        } while (i < numbers.length);
    }
}
