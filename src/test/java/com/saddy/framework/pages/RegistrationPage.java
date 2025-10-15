package com.saddy.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    private By firstName = By.xpath("//input[@id='firstName']");
    private By email = By.xpath("//input[@id='email']");
    private By country = By.xpath("//select[@id='country']");
    private By maleRB = By.xpath("//input[@id='male']");
    private By femaleRB = By.xpath("//input[@id='female']");
    private By testingCB = By.xpath("//input[@id='testing']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String fName) {
        sendKeys(firstName, fName);
    }

    public void enterEmailID(String emailId) {
        sendKeys(email, emailId);
    }

    public void selectCountry(String countryToSelect) {
        selectByVisibleText(country, countryToSelect);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male"))
            selectMale();
        else if (gender.equalsIgnoreCase("female")) {
            selectFemale();
        }
//        else if (gender.equalsIgnoreCase("other")) {
//            selectOther();
//        }
        else {
            System.out.println("There is no such cases %s matched! Hence selecting male!".formatted(gender));
            selectMale();
//            Assert.fail("There is no such cases %s matched!".formatted(gender));
        }
    }

    private void selectMale() {
        click(maleRB);
    }

    private void selectFemale() {
        click(femaleRB);
    }

    public void selectTesting() {
        WebElement checkBox = getElement(testingCB);
        if (!checkBox.isSelected())
            click(testingCB);
    }
}
