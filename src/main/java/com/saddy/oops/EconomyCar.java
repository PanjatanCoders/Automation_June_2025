package com.saddy.oops;

public abstract class EconomyCar {
    // Abstract method to be implemented by subclasses
    public abstract void carModel(String modelName);

    // Concrete method with default implementation
    public void breakFun() {
        System.out.println("Economy Car Breaks");
    }
}
