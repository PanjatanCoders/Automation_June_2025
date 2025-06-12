package com.saddy.arrays;

import java.util.Arrays;

public class ArrayDemo2 {
    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] numbers = {10, 20, 12, 30, 22, 40, 50};

        // Fetch the data from the array
        System.out.println("Element at index 0: " + numbers[0]);
        System.out.println("Element at index 1: " + numbers[1]);

        // Assign or modify an element in the array
//        numbers[1] = 100;
//
//        String s = "Hello";
//        s.length();
//
//        System.out.println("Modified Array: " + Arrays.toString(numbers));
//        System.out.println("Length of the array: " + numbers.length);

//        int[] numbers2 = numbers;
//        System.out.println("Copied Array: " + Arrays.toString(numbers2));
//
//        numbers2[4] = 500;
//        System.out.println("Original numbers Array after modification: " + Arrays.toString(numbers));
//        System.out.println("Modified numbers2 Array: " + Arrays.toString(numbers2));

//        int[] numbers3 = Arrays.copyOf(numbers, numbers.length);
//        System.out.println("Copied Array: " + Arrays.toString(numbers3));
//        numbers3[4] = 500;
//        System.out.println("Original numbers Array after modification: " + Arrays.toString(numbers));
//        System.out.println("Modified numbers3 Array: " + Arrays.toString(numbers3));

        // Array length can not be changed after creation
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        int[] arr = Arrays.copyOfRange(numbers, 2, 5);
        System.out.println("Copied Range of Array: " + Arrays.toString(arr));
        Arrays.fill(numbers, 10);
        System.out.println("Array after filling with 0: " + Arrays.toString(numbers));
        Arrays.fill(numbers, 3, 5, 20);
        System.out.println("Array after filling range with 20: " + Arrays.toString(numbers));

    }
}
