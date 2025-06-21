package com.saddy.exceptionhandling;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExceptionDemo2 {
    public void readFile(String filePath) throws IOException {
//        FileReader reader = new FileReader(new File(filePath));
//        BufferedReader bufferedReader = new BufferedReader(reader);
//
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }

        System.out.println(Files.readString(Paths.get(filePath)));
    }
}
