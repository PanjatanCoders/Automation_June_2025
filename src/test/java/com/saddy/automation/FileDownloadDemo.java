package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.saddy.automation.ScreenshotDemo.captureCompleteScreen;

public class FileDownloadDemo {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        String downloadPath = System.getProperty("user.dir") + "\\data\\";

        Map<String, Object> prefs = new HashMap<>();
        // Set the default download directory
        prefs.put("download.default_directory", downloadPath);
        // Optional: Disable download prompts
        prefs.put("download.prompt_for_download", false);
        // Optional: Disable pop-ups
        prefs.put("profile.default_content_settings.popups", 0);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");
//        options.addArguments("--headless");

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
