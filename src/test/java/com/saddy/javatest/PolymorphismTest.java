package com.saddy.javatest;

import com.saddy.polymorphism.Animal;
import com.saddy.polymorphism.Cow;
import com.saddy.polymorphism.Dog;

public class PolymorphismTest {
    static Animal obj;
    public static void main(String[] args) {
        soundTest("Cow");
    }

    static void soundTest(String animalName) {
        if (animalName.equals("Dog"))
            obj = new Dog();
        else if (animalName.equals("Cow"))
            obj = new Cow();
        else
            System.out.println("No match found. Please try again!");

        obj.makeSound();
    }
}
