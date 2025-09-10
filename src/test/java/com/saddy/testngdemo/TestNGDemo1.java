package com.saddy.testngdemo;

import org.testng.annotations.Test;

public class TestNGDemo1 {
//    public static void main(String[] args) {
//        csvDownloadTest();
//        excelDownloadTest();
    ////        textDownloadTest();
//    }

    @Test
    static void csvDownloadTest() {
        System.out.println("CSV Test Run Successfully");
    }

    @Test
    static void excelDownloadTest() {
        System.out.println("Excel Test Run Successfully");
    }

    @Test
    static void textDownloadTest() {
        System.out.println("Text Test Run Successfully");
    }
}
