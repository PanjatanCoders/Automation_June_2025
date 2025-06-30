package com.saddy.javatest;

import com.saddy.miscellenous.DemoStatic;

public class TestStatic {
    public static void main(String[] args) {
        System.out.println(DemoStatic.a);

        DemoStatic demo = new DemoStatic();

        System.out.println(demo.a);
        System.out.println(demo.b);
    }
}
