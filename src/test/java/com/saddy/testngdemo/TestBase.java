package com.saddy.testngdemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void launchBrowser() {
        System.out.println("Browser launched");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Browser closed!!\n");
    }
}
