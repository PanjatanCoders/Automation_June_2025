package com.saddy;

import com.saddy.accessmodifier.ClassA;

public class ClassATest extends ClassA{
    public void printPrivateField() {
        ClassA classA = new ClassA();
//        classA.privateField; // This line would cause a compile-time error because privateField is not accessible here.
        classA.displayPrivateField(); // This is allowed because displayPrivateField is public.
//        classA.displayName(); // This line would cause a compile-time error because displayName is private.
        System.out.println(protectedField);
    }
}
