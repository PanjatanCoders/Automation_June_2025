package com.saddy.automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotDemo {
    static WebDriver driver;
    static TakesScreenshot ts = (TakesScreenshot) driver;
    static String filePath = "G:\\AutomationProjects\\Automation_June_2025\\data\\";
    public static void main(String[] args) throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://panjatan.netlify.app/");
        System.out.println(driver.getTitle());

        captureCompleteScreen();

        captureElementScreenShot();


        Thread.sleep(2000);
        driver.quit();
    }

    static void captureElementScreenShot() throws IOException {
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
        File src = dropDown.getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath + "element_ss.png");
        FileUtils.copyFile(src, dest);
    }

    static void captureCompleteScreen() {

        try {
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath+ "screenshot.png");
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved to: " + filePath);
        } catch (Exception e) {
            System.err.println("Error taking screenshot: " + e.getMessage());
        }
    }
}
