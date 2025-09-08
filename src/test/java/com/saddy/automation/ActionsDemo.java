package com.saddy.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.time.Duration;

public class ActionsDemo {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://panjatan.netlify.app/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("abc@in.com");


        Thread.sleep(2000);
        WebElement fName = driver.findElement(By.xpath("//input[@id='firstName']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(fName).build().perform();
        actions.moveToElement(fName).perform();

//        Thread.sleep(5000);
//        String text = driver.findElement(By.xpath("//*[contains(.,'Please fill out this field')]")).getText();
//        System.out.println(text);

        WebElement item3 = driver.findElement(By.xpath("//div[.='Item 3']"));
        actions.scrollToElement(item3).build().perform();
//        actions.moveToElement(item3).build().perform();
//
//        WebElement dest = driver.findElement(By.xpath("//div[@id='dropZone']"));
//
//        Thread.sleep(2000);
//        actions.dragAndDrop(item3, dest).build().perform();
//        actions.sendKeys(Keys)



        Thread.sleep(10000);
        driver.quit();
    }

}
