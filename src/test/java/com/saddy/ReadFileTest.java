package com.saddy;

import com.saddy.exceptionhandling.ExceptionDemo2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileTest {
    static ExceptionDemo2 exceptionDemo2;
    public static void main(String[] args) {
        exceptionDemo2 = new ExceptionDemo2();
        printFileDetails();
    }
    static void getFileDetails() {
        try {
            exceptionDemo2.readFile("test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void printFileDetails() {
        try {
            exceptionDemo2.readFile("test.txt");
        } catch (IOException e) {
            System.out.println("The File is not found. So passing the default file");
            String filePath = System.getProperty("user.dir") + "\\data\\test.txt";
            System.out.println("FilePath: "+ filePath);
            try {
                exceptionDemo2.readFile(filePath);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
