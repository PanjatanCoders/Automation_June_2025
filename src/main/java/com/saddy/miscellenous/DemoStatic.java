package com.saddy.miscellenous;

public class DemoStatic {
    public static int a = 10;
    public int b = 20; // Instance variable// non-static variable//Class variable//Global variable

    public void display() { //Non-static method//Instance method
        System.out.println("Static variable a: " + a);
        System.out.println("Instance variable b: " + b);
//        staticDisplay();
    }

    public void print() {
        display();
    }

    public static void staticDisplay() { //Static method
        System.out.println("Static variable a: " + a);
        // System.out.println("Instance variable b: " + b); // Cannot access non-static variable from static context
        DemoStatic demo = new DemoStatic(); // Create an instance to access non-static variable
        demo.display();
//        System.out.println(b);
    }
}
