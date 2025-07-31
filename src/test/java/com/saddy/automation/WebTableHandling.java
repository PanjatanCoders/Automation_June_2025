package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class WebTableHandling {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://panjatan.netlify.app/table");
//
//        Select rowsPerPage = new Select(driver.findElement(By.id("rows-per-page")));
//        rowsPerPage.selectByVisibleText("50");
//
        Thread.sleep(2000);
//        List<WebElement> containerIds = driver.findElements(By.xpath("//td[.='In Transit']/preceding-sibling::td[3]"));
//        System.out.println("Total containers in transit: " + containerIds.size());
//
//        for (WebElement containerId : containerIds) {
//            System.out.println("Container ID: " + containerId.getText());
//        }
//        List<WebElement> tds = driver.findElements(By.xpath("//tbody//td"));
//        System.out.println("Total cells in the table: " + tds.size());
//        for (WebElement td : tds) {
//            System.out.println("Cell Text: " + td.getText());
//        }
//        String container3Xpath = "//tbody//td[.='CONT003']/..";
//        WebElement container3Row = driver.findElement(By.xpath(container3Xpath));
//
//        List<WebElement> cols = container3Row.findElements(By.tagName("td"));
//
//        for (WebElement col : cols) {
//            System.out.println("Column Text: " + col.getText());
//        }

        List<WebElement> cols = driver.findElements(By.xpath("//tbody//td[.='CONT003']/../td"));
        System.out.println("Total columns in the row with CONT003: " + cols.size());
//        for (WebElement col : cols) {
//            System.out.println("Column Text: " + col.getText());
//        }

        int colCount = cols.size();

        for (int i = 1; i <= colCount; i++) {
            String cellXpath = "//tbody//td[.='CONT003']/../td[" + i + "]";
            WebElement cell = driver.findElement(By.xpath(cellXpath));
            System.out.println("Column " + i + " Text: " + cell.getText());
        }

        driver.quit();
    }
}
