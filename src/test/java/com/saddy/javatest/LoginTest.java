package com.saddy.javatest;

import com.saddy.constructor.Login;

public class LoginTest {
    public static void main(String[] args) {
        Login obj = new Login();

        Login login = new Login("beta"); // Create an instance of the Login class

        Login login1 = new Login("prod"); // Create an instance of the Login class

        login.login("admin", "password");
        login1.login("admin", "password");
    }
}
