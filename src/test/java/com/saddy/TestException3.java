package com.saddy;

import com.saddy.exceptionhandling.ExceptionDemo3;

public class TestException3 {
    public static void main(String[] args) {
        ExceptionDemo3 exceptionDemo3 = new ExceptionDemo3();
        exceptionDemo3.getPersonCategory(20);
        exceptionDemo3.getPersonCategory(10);
        exceptionDemo3.getPersonCategory(-10);
    }
}
