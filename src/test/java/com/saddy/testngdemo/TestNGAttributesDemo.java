package com.saddy.testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAttributesDemo extends TestBase{

    @Test(enabled = true, priority = 1, groups = "Sanity")
    public void attributeTest_TC001() {
        System.out.println("Inside test001");
        Assert.assertEquals(10, 10);
    }

    @Test(dependsOnMethods = "attributeTest_TC001", priority = 2, groups = {"Sanity","Regression"})
    public void attributeTest_TC002() {
        System.out.println("Inside test002");
    }

    @Test(priority = 3, dependsOnGroups = "Sanity", alwaysRun = true)
    public void attributeTest_TC003() {
        System.out.println("Inside test003");
    }

    @Test(priority = 4, description = "Verification of Dashboard page")
    public void attributeTest_TC004() {
        System.out.println("Inside test004");
    }

    @Test(priority = 5, invocationCount = 3)
    public void attributeTest_TC005() {
        System.out.println("Inside test005");
    }

    @Test(priority = 6)
    public void attributeTest_TC006() {
        System.out.println("Inside test006");
    }
}
