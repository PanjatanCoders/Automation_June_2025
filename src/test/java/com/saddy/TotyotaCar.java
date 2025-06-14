package com.saddy;

public class TotyotaCar implements Car{
    @Override
    public void carModel(String modelName) {
        System.out.println("Totyota Car Model: " + modelName);
    }

    @Override
    public void breakFun() {
        System.out.println("Totyota Car Breaks");
    }

    public static void main(String[] args) {
        TotyotaCar car = new TotyotaCar();
        car.carModel("Corolla");
        car.breakFun();
    }
}
