package com.saddy.accessmodifier;

public class ClassB {

    public void printPrivateField() {
        ClassA classA = new ClassA();

//        classA.privateField; // This line would cause a compile-time error because privateField is not accessible here.
        classA.displayPrivateField(); // This is allowed because displayPrivateField is public.
//        classA.displayName(); // This line would cause a compile-time error because displayName is private.
        System.out.println(classA.protectedField);
        System.out.println(classA.publicField); // This is allowed because publicField is public.
        classA.defaultMethod();
    }

    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.printPrivateField(); // This will print "Private Field" to the console.
    }
}
