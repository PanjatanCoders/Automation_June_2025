package com.saddy;

import com.saddy.oops.EncapsulationDemo;

public class EncapsulationTest {
    public static void main(String[] args) {
        EncapsulationDemo encapsulationDemo = new EncapsulationDemo();
//        encapsulationDemo.name = "Saddam"; // This line will cause a compilation error because 'name' is private
        encapsulationDemo.setName("Saddam Hossain");
        System.out.println("Name: " + encapsulationDemo.getName());
    }
}
