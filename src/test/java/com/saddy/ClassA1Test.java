package com.saddy;

import com.saddy.accessmodifier.ClassA;

public class ClassA1Test {
    public void printPrivateField() {
        ClassA classA = new ClassA();
        System.out.println(classA.publicField);
//        classA.defaultMethod(); // This is allowed because defaultMethod is package-private and ClassA1Test is in the same package.
    }
}
