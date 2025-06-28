package com.saddy;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/data/TestFile.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        // You can use Apache POI or any other library to read the Excel file here

//        Workbook wb = new HSSFWorkbook(fileInputStream); // For .xls files
        Workbook wb1 = new XSSFWorkbook(fileInputStream); // For .xlsx files

        Sheet sheet = wb1.getSheet("employee");

        String nameJohn = sheet.getRow(2).getCell(0).getStringCellValue();

        System.out.println("Name of John: " + nameJohn);
        System.out.println("Name of age: " + (int) sheet.getRow(2).getCell(1).getNumericCellValue());

        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getPhysicalNumberOfRows());
        System.out.println(sheet.getRow(0).getLastCellNum());

    }
}
