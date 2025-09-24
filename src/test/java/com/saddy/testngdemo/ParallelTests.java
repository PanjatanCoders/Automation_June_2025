package com.saddy.testngdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTests {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        WebDriver webDriver;
        if (browser.equals("chrome"))
            webDriver = new ChromeDriver();
        else if (browser.equals("firefox"))
            webDriver = new FirefoxDriver();
        else
            webDriver = new EdgeDriver();

        driver.set(webDriver);
    }

    @Test
    public void parallelTest1() {
        driver.get().get("https://panjatan.netlify.app/");
        // Test implementation
        System.out.println("Title from Test1: " + driver.get().getTitle());
    }

    @Test
    public void parallelTest2() {
        driver.get().get("https://panjatan.netlify.app/table");
        // Test implementation
        System.out.println("Title from Test2: " + driver.get().getTitle());
    }

    @Test
    public void parallelTest3() {
        driver.get().get("https://panjatan.netlify.app/table");
        // Test implementation
        System.out.println("Title from Test3: " + driver.get().getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}