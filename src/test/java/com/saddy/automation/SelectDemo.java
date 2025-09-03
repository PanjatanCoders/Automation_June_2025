package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectDemo {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://panjatan.netlify.app/");
        System.out.println(driver.getTitle());

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(dropDown);
//        select.selectByVisibleText("India");
//        select.selectByValue("in");
//        select.selectByIndex(2);
        select.selectByContainsVisibleText("ted S");
        Thread.sleep(700);
        String selectedData = select.getFirstSelectedOption().getText();
        System.out.println("Selected data: " + selectedData);
        Assert.assertEquals(selectedData, "United State");
        Thread.sleep(3000);
        driver.quit();
    }
}
