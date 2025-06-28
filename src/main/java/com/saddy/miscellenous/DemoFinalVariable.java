package com.saddy.miscellenous;

public class DemoFinalVariable {

    final int a  = 100;
    final String hostname = "localhost";
    int b  = 20;

    public static void main(String[] args) {
        DemoFinalVariable demo = new DemoFinalVariable();

        // Trying to change the value of final variable 'a'
        // This will cause a compilation error
//         demo.a = 200; // Uncommenting this line will result in an error
        demo.b = 30; // This is allowed as 'b' is not final

        System.out.println("The value of final variable a is: " + demo.a);
    }
}
