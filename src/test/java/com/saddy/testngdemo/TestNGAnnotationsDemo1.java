package com.saddy.testngdemo;

import org.testng.annotations.*;

public class TestNGAnnotationsDemo1 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Inside Before Test");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Inside After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Inside After Test\n");
    }

    @Test
    public void loginTestTC001() {
        System.out.println("Login with valid credentials");
    }

    @Test
    public void loginTestTC002() {
        System.out.println("Login with invalid credentials");
    }

    @Test
    public void loginTestTC003() {
        System.out.println("Login with blank credentials");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Inside before class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("==========Inside before method==========");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("==========Inside after method==========\n");
    }
}
