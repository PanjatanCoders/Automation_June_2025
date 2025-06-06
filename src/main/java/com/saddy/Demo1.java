package com.saddy;

public class Demo1 {

    static String name = "Saddam Hossain";

    public static void displayName(){
        System.out.println("Hello, Saddy!");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Demo1 class!");
        System.out.println("Name: " + name);
        displayName();
        long age = 423423583245345L;
        System.out.println("Age: " + age);
        if ((age < 18) && (age > 100)) {
            System.out.println("This will never be printed.");
        } else {
            System.out.println("This will always be printed.");
        }
    }

}
