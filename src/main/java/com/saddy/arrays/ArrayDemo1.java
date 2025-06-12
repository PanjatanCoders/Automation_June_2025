package com.saddy.arrays;

import java.util.Arrays;

public class ArrayDemo1 {
    public static void main(String[] args) {
        // Declaring and initializing an array
        int[] numbers1 = {10, 20, 30, 40, 50}; //most preferred way
        int []numbers2= {10, 20, 30, 40, 50};
        int numbers3[] = {10, 20, 30, 40, 50};

        int[] array1; // Declaration of an array variable
        // Assigning values to the array
        array1 = new int[5]; // Creating an array of size 5 & by default all elements are initialized to 0
        String[] array2 = new String[5]; // Creating an array of size 5 for Strings, initialized to null
        Boolean[] array3 = new Boolean[5]; // Creating an array of size 5 for Booleans, initialized to null

        System.out.println("numbers 1: " + Arrays.toString(numbers1));
        System.out.println("numbers 2: " + Arrays.toString(numbers2));
        System.out.println("numbers 3: " + Arrays.toString(numbers3));
        System.out.println("array 1: " + Arrays.toString(array1));
        System.out.println("array 2: " + Arrays.toString(array2));
        System.out.println("array 3: " + Arrays.toString(array3));
    }
}
