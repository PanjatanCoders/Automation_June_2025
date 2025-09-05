package com.saddy.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDemo2 {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://panjatan.netlify.app/");
        System.out.println(driver.getTitle());

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(dropDown);

        List<WebElement> ddValues = select.getAllSelectedOptions(); //Applicable for multi
        // dropdown. And return all selected items

        List<WebElement> actualValues = select.getOptions();

        actualValues.forEach(element -> System.out.println(element.getText()));

        System.out.println("*".repeat(40));

//        select.deselectAll(); //used for multiple select dropdowns to unselect all values

        System.out.println(select.isMultiple());


        Thread.sleep(3000);
        driver.quit();
    }
}
