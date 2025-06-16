package com.saddy;

import com.saddy.oops.EconomyCar;

public class AbstractClassTest extends EconomyCar {
    @Override
    public void carModel(String modelName) {
        System.out.println("Economy Car Model: " + modelName);
    }

    public static void main(String[] args) {
        AbstractClassTest car = new AbstractClassTest();
        car.carModel("Toyota Corolla");
        car.breakFun();
    }
}
