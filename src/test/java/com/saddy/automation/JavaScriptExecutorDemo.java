package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://panjatan.netlify.app/");
        System.out.println(driver.getTitle());

        WebElement loginBtn = driver.findElement(By.xpath("//button[.='Login']"));
//        JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", loginBtn);
        js.executeScript("document.getElementById('username').value = 'Saddam Hossain';");

        WebElement bio = driver.findElement(By.id("bio"));

        js.executeScript("arguments[0].value='I am learning Selenium';", bio);


        Thread.sleep(10000);
        driver.quit();
    }
}
