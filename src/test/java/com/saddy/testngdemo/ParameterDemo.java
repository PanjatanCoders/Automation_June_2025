package com.saddy.testngdemo;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {

    @Parameters("param1")
    @BeforeSuite
    public void beforeSuite(String p1) {
        System.out.println("Value inside beforeSuite: " + p1);
    }

//    @Parameters("param1")
//    @Parameters("classLevel") //It is not accessible at Test Level
    @BeforeTest
    public void beforeTest() {
        System.out.println("Value inside beforeTest: ");
    }


    @Parameters("param1")
    @Test
    public void parameterDemo1(String param) {
        System.out.println("Param1 Value: " + param);
    }

    @Parameters({"param1", "classLevel"})
    @Test
    public void parameterDemo2(String p1, String p2) {
        System.out.println("Running Test parameterDemo2. Value1: " + p1);
        System.out.println("Running Test parameterDemo2. Value2: " + p2);
    }

    @Parameters({"userid", "pwd"})
    @Test
    public void parameterDemo3(String user, String password) {
        System.out.println("\nUser: "+ user + "\nPassword: " + password);
    }

}
