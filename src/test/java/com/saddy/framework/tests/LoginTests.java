package com.saddy.framework.tests;

import com.saddy.framework.pages.LoginPage;
import org.testng.Assert;
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
//        validate the login success
//        String actualText = loginPage.getLoginAlertMessage();
        Assert.assertEquals(loginPage.getLoginAlertMessage(), "Login successful!");
    }

    @Test
    public void loginWithInValidCredentials_TC002() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUserName("admin1");
//        loginPage.enterPassword("password1");
//        loginPage.clickLoginBtn();
        loginPage.login("admin", "password1");
//        Validate error message
//        String actualText = loginPage.getLoginAlertMessage();
        Assert.assertEquals(loginPage.getLoginAlertMessage(), "Invalid password! Please check your password.");

    }
}
