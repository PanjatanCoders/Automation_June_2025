package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://panjatan.netlify.app/");
        System.out.println(driver.getTitle());

        //click, sendKeys, getText, getAttribute, Select class(selectByVisibleText, ByIndex, ByValue),
        // Switch, Alert(accept, dismiss, getText, sendKeys)

        // Enter user id & pwd in respective fields
        driver.findElement(By.id("login-email")).sendKeys("test@example.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.xpath("//button[.='Log In']")).click();
        String actualText = driver.findElement(By.id("login-message")).getText();

        System.out.println("Data fetched from UI: " + actualText);
        if (actualText.equals("Login successful! Welcome!"))
            System.out.println("Test Passed!!!");
        else
            System.out.println("Test Failed!!");

        Thread.sleep(3000);
        driver.quit();
    }
}
