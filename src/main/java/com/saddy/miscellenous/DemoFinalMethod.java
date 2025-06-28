package com.saddy.miscellenous;

public class DemoFinalMethod {

//    By Making a method final, we prevent it from being overridden in subclasses.
    public final void display() {
        System.out.println("This is a final method.");
    }

    // Uncommenting the below method will cause a compilation error
    // because we cannot override a final method.

    //Method Overloading is allowed even if the method is final.
    public void display(int a) {
        System.out.println("Trying to override a final method.");
    }

    public static void main(String[] args) {
        DemoFinalMethod demo = new DemoFinalMethod();
        demo.display();
    }
}

class ChildClass extends DemoFinalMethod{
//    public void display() {
//        System.out.println("Trying to override a final method in child class.");
//    }
}
