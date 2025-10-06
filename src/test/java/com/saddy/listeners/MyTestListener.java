package com.saddy.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import static com.saddy.automation.ScreenshotDemo.driver;

public class MyTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getMethod().getMethodName());
//        System.out.println(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getMethod().getMethodName());
        System.out.println("Failure Reason: " + result.getThrowable());

        // Take screenshot on failure
        takeScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }

    private void takeScreenshot(String testName) {
        // Screenshot implementation
        System.out.println("Screenshot taken for: " + testName);
        TakesScreenshot ts = (TakesScreenshot) driver;
        String filePath = "/target/" + "Screenshot";
        try {
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath + ".png");
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved to: " + filePath);
        } catch (Exception e) {
            System.err.println("Error taking screenshot: " + e.getMessage());
        }
    }
}
