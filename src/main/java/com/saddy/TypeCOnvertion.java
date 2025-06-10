package com.saddy;

public class TypeCOnvertion {
    public static void main(String[] args) {
//        Widening/ Narrowing Conversion
        // Widening Conversion
        int a = 10;
        double d = a;
        System.out.println("Widening Conversion: " + d); // 10.0
        // Narrowing Conversion
        double b = 10.5;
        int c = (int) b; // Explicitly casting double to int
        System.out.println("Narrowing Conversion: " + c); // 10

        // String to Integer Conversion
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println("String to Integer Conversion: " + num); // 123
        String flag = "true";

        if (Boolean.parseBoolean(flag))
            System.out.println("String to Boolean Conversion: " + true); // true
    }
}
