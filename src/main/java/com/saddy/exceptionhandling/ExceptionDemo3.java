package com.saddy.exceptionhandling;

public class ExceptionDemo3 {
    public void getPersonCategory(int age) {
        System.out.println("Age received: " + age);
        if (age >= 18)
            System.out.println("Adult");
        else if (age > 0)
            System.out.println("Minor");
        else if (age <= 0)
            throw new IllegalArgumentException();
    }
}
