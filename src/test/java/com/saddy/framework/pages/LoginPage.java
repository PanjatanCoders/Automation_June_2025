package com.saddy.framework.pages;

import com.saddy.constructor.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

//    @FindBy(xpath = "//input[@id='username']")
    private By userName = By.xpath("//input[@id='username']");

//    @FindBy(xpath = "//input[@id='password']")
    private By password = By.xpath("//input[@id='password']");

//    @FindBy(xpath = "//button[.='Login']")
    private By loginBtn = By.xpath("//button[.='Login']");

//    Login page constructor. Passing the driver instance to Parent BasePage using super()
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String userId) {
        sendKeys(userName, userId);
    }

    public void enterPassword(String pwd) {
        sendKeys(password, pwd);
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }

}
