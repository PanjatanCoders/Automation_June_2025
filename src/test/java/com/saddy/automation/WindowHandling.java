package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class WindowHandling {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://panjatan.netlify.app/");

        swithToNewWindow();

        String text = driver.findElement(By.xpath("//div[@id='windowInfo']/p")).getText();
        System.out.println(text);
        Thread.sleep(3000);
        driver.quit();
    }

    static void swithToNewWindow() throws InterruptedException {
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        driver.findElement(By.xpath("//button[@id='openWindowBtn']")).click();
        //Switch to the new window
        Thread.sleep(2000);
        Set<String> windows = driver.getWindowHandles(); //return the names of the windows in Set
        System.out.println(windows);

        windows.remove(mainWindow);
        String targetWindow="";
        for (String win : windows)
            targetWindow = win;

        System.out.println("Target Window: " + targetWindow);
        driver.switchTo().window(targetWindow);
        String text =
                driver.findElement(By.xpath("//p[.='This is a new window for testing.']")).getText();
        System.out.println("Text fetched: " + text);
        driver.close();

        Thread.sleep(1000);
        driver.switchTo().window(mainWindow); //switch back to main window


//        System.out.println("Title of the new window: " + driver.getTitle());
//        driver.switchTo().newWindow(WindowType.WINDOW);
//        System.out.println("Title of the new window: ".concat(Objects.requireNonNull(driver.getTitle())));
    }
}
