package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FrameHandling {
        static WebDriver driver;
        public static void main(String[] args) throws InterruptedException {
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://panjatan.netlify.app/");

        swithToFrame();
        String headTitle = driver.findElement(By.xpath("//section[@id='advanced']//h2")).getText();
        System.out.println("Title Fetched: " + headTitle);
        Thread.sleep(3000);
        driver.quit();
    }

        static void swithToFrame() {
            driver.switchTo().frame("testIframe");      // Switching to a frame with its
            // id=testIframe
            String text = driver.findElement(By.xpath("//h2[.='Iframe Content']")).getText();
            System.out.println("Text inside Frame: " + text);
//            driver.switchTo().parentFrame(); // to switch back to parent
            driver.switchTo().defaultContent(); //to switch back to main window from any level of
            // child frame
//            driver.switchTo().frame("id of child leve2")
        }
}
