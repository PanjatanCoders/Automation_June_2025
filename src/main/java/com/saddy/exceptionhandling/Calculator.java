package com.saddy.exceptionhandling;

public class Calculator {
    public void calculateDivision(int a, int b) {
        try {
            int result  = a/b;
            System.out.println("Division of two number: " + result);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Division by zero is not possible! " + e.getMessage());
        } finally {
            System.out.println("Inside the finally block");
        }
    }
}
