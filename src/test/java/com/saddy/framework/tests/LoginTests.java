package com.saddy.framework.tests;

import com.saddy.framework.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void loginWithValidCredentials_TC001() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUserName("admin");
        loginPage.enterPassword("password");
        loginPage.clickLoginBtn();
    }
}
