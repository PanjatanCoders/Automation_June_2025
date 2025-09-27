package com.saddy.testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertDemo {

    @Test
    public void assertTest_TC001() {
        System.out.println("Print from TC001");
        Assert.assertEquals(20, 20);  //Hard Assert
        System.out.println("Print after Hard Assert");
    }

    @Test
    public void assertTest_TC002() {
        System.out.println("Print from TC002");
        Assert.assertEquals(20, 22);  //Hard Assert
        System.out.println("Print after Hard Assert");
    }

    @Test
    public void assertTest_TC003() {
        System.out.println("Print from TC003");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(20, 20);
        System.out.println("Print after Soft Assert");
        softAssert.assertAll();
    }

    @Test
    public void assertTest_TC004() {
        System.out.println("Print from TC004");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(20, 22);
        System.out.println("Print after Soft Assert");
        softAssert.assertAll();
    }

    @Test
    public void assertTest_TC005() {
        System.out.println("Print from TC005");
        SoftAssert softAssert = new SoftAssert();
        boolean expectedStatus = true;

        softAssert.assertEquals(20, 22, "");

        softAssert.assertTrue(true, "Assertion1 is not pass");

        softAssert.assertEquals(false, expectedStatus, "Login field is not enabled");
        softAssert.assertTrue(true, "Assertion3 is not pass");

        System.out.println("Print after Soft Assert");
        softAssert.assertAll();
    }
    @Test
    public void assertTest_TC006() {
        Assert.assertNotEquals(22, 20);
    }
}
