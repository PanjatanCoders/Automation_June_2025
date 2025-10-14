package com.saddy.framework.tests;

import com.saddy.framework.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    LoginPage loginPage;

    @BeforeMethod
    public void beforeLogin() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidCredentials_TC001() {
//        loginPage.enterUserName("admin");
//        loginPage.enterPassword("password");
//        loginPage.clickLoginBtn();
        loginPage.login("admin", "password");
    }

    @Test
    public void loginWithInValidCredentials_TC002() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUserName("admin1");
//        loginPage.enterPassword("password1");
//        loginPage.clickLoginBtn();
        loginPage.login("admin1", "password1");

    }
}
