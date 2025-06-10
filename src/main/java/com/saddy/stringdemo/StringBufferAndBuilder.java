package com.saddy.stringdemo;

public class StringBufferAndBuilder {
    public static void main(String[] args) {
//        String s = "Hello";
        stringBufferDemo();
//        stringBuilderDemo();
    }

    public static void stringBufferDemo() {
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println(sb);
        sb.append(" World");
        System.out.println(sb.toString()); // Output: Hello World
        sb.insert(3, " u ");
        System.out.println(sb.toString()); // Output: Hello, World
        sb.delete(5, 10);
        System.out.println(sb.toString()); // Output: Hello World
        System.out.println(sb.reverse());
        System.out.println(sb.capacity()); // Output: 34 (default capacity is 16 + length of string)
    }

    public static void stringBuilderDemo() {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);
        sb.append(" World");
        System.out.println(sb.toString()); // Output: Hello World
        sb.insert(5, ",");
        System.out.println(sb.toString()); // Output: Hello, World
        sb.delete(5, 6);
        System.out.println(sb.toString()); // Output: Hello World
    }

    void display() {
        for (int i = 0; i < 10; i++) {
            String s = "Hello " + i;
            System.out.println(s);
        }
    }
}
