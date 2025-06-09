package com.saddy.stringdemo;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "Hello, World!"; // String literal
        String str2 = "Hello, World!";
        String str3 = new String("Hello, World!"); // String illiteral with new keyword
        String str4 = new String("Hello, World!"); // Another string illiteral

        // Comparing strings using '=='
        System.out.println("Using '==':");
        System.out.println("str1 == str2: " + (str1 == str2)); // true, same reference
        System.out.println("str1 == str3: " + (str1 == str3)); // false, different reference
        System.out.println("str3 == str4: " + (str3 == str4)); // false, different references

        // Comparing strings using 'equals()' - it verifies content equality
        System.out.println("\nUsing 'equals()':");
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true, same content
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true, same content
    }

}
