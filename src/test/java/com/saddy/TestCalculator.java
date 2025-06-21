package com.saddy;

import com.saddy.exceptionhandling.Calculator;

public class TestCalculator {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.calculateDivision(34, 5);
        cal.calculateDivision(34, 0);
        System.out.println("End of Calculator Test");
    }
}
