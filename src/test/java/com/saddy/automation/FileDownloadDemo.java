package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.saddy.automation.ScreenshotDemo.captureCompleteScreen;

public class FileDownloadDemo {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://panjatan.netlify.app/table");
        String xpath = "//input[@id='fileInput']";

        driver.findElement(By.xpath("//button[@id='download-csv']")).click();

        System.out.println(driver.getTitle());
        captureCompleteScreen("FileDownloadDemo", driver);
        Thread.sleep(6000);
        driver.quit();
    }
}
