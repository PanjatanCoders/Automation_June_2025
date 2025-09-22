package com.saddy.testngdemo;

import org.testng.annotations.DataProvider;

public class DataProvideClass {

    @DataProvider(name = "credentials")
    public Object[][] loginData() {
        return new Object[][] {
                {"user1", "pass1", "Login Success"},
                {"user2", "pass2", "Login Failed"},
                {"user3", "pass3", "Login Failed"}
        };
    }
}
