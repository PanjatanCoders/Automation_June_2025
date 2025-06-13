package com.saddy.accessmodifier;

public class ClassA {
    private String privateField = "Private Field";
    protected String protectedField = "Protected Field";
    public String publicField = "Public Field";
    String defaultField = "Default Field"; // package-private

    public void displayPrivateField() {
        System.out.println(privateField);
    }

    private void displayName() {
        System.out.println("Name: ClassA");
    }
    // This method is default (package-private) and can be accessed within the same package.
    void defaultMethod() {
        System.out.println("Default Method: ClassA");
    }
}

class A1{
    public void printFromClassA() {
        ClassA classA = new ClassA();
        classA.displayPrivateField(); // This is allowed because displayPrivateField is public.
//         classA.displayName(); // This line would cause a compile-time error because displayName is private.
        System.out.println(classA.protectedField); // This is allowed because A1 is in the same package as ClassA.
        System.out.println(classA.publicField); // This is allowed because publicField is public.
        classA.defaultMethod(); // This is allowed because defaultMethod is package-private and A1 is in the same package.
    }
}