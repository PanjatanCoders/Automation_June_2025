package com.saddy;

import com.saddy.exceptionhandling.ExceptionDemo1;

public class ExceptionDemo1Test {

    static ExceptionDemo1 exceptionDemo1;

    public static void main(String[] args) {
        exceptionDemo1 = new ExceptionDemo1();
        printNumber(5);
    }


    static void printNumber(int index){
        exceptionDemo1.displayNumber(index);
    }
}
