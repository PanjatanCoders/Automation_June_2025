package com.saddy.oops;

public class Bus extends Vehicle{
    public void startVehicle() {
        System.out.println("Bus is starting");
        start();
//        stop(); // This line is incorrect because stop() is private in Vehicle and cannot be accessed here.
        breakBusFun();
    }


    public void breakBusFun() {
        System.out.println("Bus Breaks");
    }
}
