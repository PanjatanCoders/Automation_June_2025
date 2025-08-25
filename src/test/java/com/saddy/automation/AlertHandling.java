package com.saddy.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AlertHandling {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://panjatan.netlify.app/");
        System.out.println(driver.getTitle());

//        Handling Alert
        try  {

//            handleAlertInfo();
//            confirmAlertHandling();
            handlingPromptAlert();

            String actualResult =
                    driver.findElement(By.xpath("//div[@id='alertResult']/p")).getText();

            System.out.println(actualResult);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        Thread.sleep(3000);
        driver.quit();
    }

    static void handlingPromptAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='promptBtn']")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.sendKeys("Selenium Automation"); // to enter text into Alert box

        Thread.sleep(2000);
        alert.accept();
    }

    static void confirmAlertHandling() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Do you want to proceed?");

        Thread.sleep(2000);
//        alert.accept(); // accept is for alert Ok/Yes/✓
        alert.dismiss(); // dismiss for alert Cancel/No/X
    }

    static void handleAlertInfo() throws InterruptedException {
        driver.findElement(By.cssSelector("#alertBtn")).click();

        Alert alert = driver.switchTo().alert();  // Switching to the alert
        String actualText = alert.getText();
        Assert.assertEquals(actualText, "This is a simple alert!");

        Thread.sleep(2000);
        alert.accept();
    }
}
