package com.saddy.framework.tests;

import com.saddy.framework.pages.LoginPage;
import com.saddy.framework.pages.RegistrationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(RegistrationTest.class);
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void beforeLogin() {
        loginPage = new LoginPage(driver);
        registrationPage = loginPage.login("admin", "password");
//        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void registerUserPositive_TC001() throws InterruptedException {
        registrationPage.enterFirstName("Saddam");
        registrationPage.enterEmailID("saddam.hossain@in.com");
        registrationPage.selectCountry("India");

        registrationPage.selectGender("abc");

        registrationPage.selectTesting();
        Thread.sleep(5000);
    }
}
