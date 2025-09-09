package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUploadDemo {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://panjatan.netlify.app/");
        String xpath = "//input[@id='fileInput']";
//        String filePath = System.getProperty("user.dir") + "/data/test.txt";
        String filePath = System.getProperty("user.dir") + "\\data\\screenshot.png";

        //File upload: in this case the element should be of input tag and we need to use sendkeys for file upload
        driver.findElement(By.xpath(xpath)).sendKeys(filePath);

        String actualText = driver.findElement(By.xpath("//div[@id='fileList']/div")).getText();

        System.out.println(actualText);

        Thread.sleep(30000);
        driver.quit();
    }
}
