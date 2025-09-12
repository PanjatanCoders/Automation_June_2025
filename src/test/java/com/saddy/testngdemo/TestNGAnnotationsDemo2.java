package com.saddy.testngdemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo2 extends TestBase{

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Inside Before Method of TestNGAnnotationsDemo2");
    }

    @BeforeMethod
    public void beforeMethod1() {
        System.out.println("Inside Before Method1 of TestNGAnnotationsDemo2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Inside After Method of TestNGAnnotationsDemo2");
    }

    @Test
    public void homePageValidationTestTC001() {
        System.out.println("Inside home dashboard page");
    }
}
