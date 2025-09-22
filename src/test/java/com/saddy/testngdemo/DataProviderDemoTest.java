package com.saddy.testngdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest {

    @Test(dataProvider = "credentials", dataProviderClass = DataProvideClass.class) //to use data provider method from different class
//    @Test(dataProvider = "credentials") //to use data provider method from same class
    public void loginTest(String userid, String pwd, String msg) {
        System.out.println(
                "Userid: " + userid +
                ", Password: " + pwd +
                ", Verification Message: " + msg
        );
    }


//    @DataProvider(name = "credentials")
//    public Object[][] loginData() {
//        return new Object[][] {
//                {"user1", "pass1", "Login Success"},
//                {"user2", "pass2", "Login Failed"},
//                {"user3", "pass3", "Login Failed"}
//        };
//    }
}
