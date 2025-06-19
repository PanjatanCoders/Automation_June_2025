package com.saddy;

import com.saddy.polymorphism.ClassAA;

public class OverloadingTest {
    public static void main(String[] args) {
        ClassAA obj = new ClassAA();

        obj.m1();
        obj.m1(10);
        obj.m1("Java");


        String str = "Welcome";
        
    }
}
