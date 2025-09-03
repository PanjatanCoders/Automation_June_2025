package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://panjatan.netlify.app/");
        System.out.println(driver.getTitle());
//        useImplicitWait();
//        useExplicitWait();
        fluentWaitDemo();

        Thread.sleep(2000);
        driver.quit();
    }

    static void fluentWaitDemo() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(70))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("Test " +
                "data");
    }

    static void useExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("Test " +
                "data");
//        WebElement element =
//                wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
//        element.isDisplayed();
//        element.sendKeys("admin");
    }

    static void useImplicitWait() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[.='Login']")).click();
        String text = driver.findElement(By.id("loginAlert")).getText();
        System.out.println("message: " + text);
    }
}
