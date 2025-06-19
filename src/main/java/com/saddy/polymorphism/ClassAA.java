package com.saddy.polymorphism;

public class ClassAA {
//    example of method overloading
    public void m1() {
        System.out.println("Inside m1 with no arguments");
    }
    public void m1(int a) {
        System.out.println("Inside m1 with arguments a:" + a);
    }
    public void m1(int a, String s) {
        System.out.println("Inside m1 with arguments a, s");
    }
    public void m1(String s) {
        System.out.println("Inside m1 with arguments s");
    }
}
