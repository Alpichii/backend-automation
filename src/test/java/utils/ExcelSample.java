package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelSample {

    public static void main(String[] args) throws IOException {

        String excelFilePath = "testData/excelSample.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        // Opening the Excel file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        String firstValue = sheet.getRow(1).getCell(0).getStringCellValue();

        System.out.println("My first value in the row is " + firstValue);

        int lastRowNum = sheet.getLastRowNum();
        System.out.println("The last row number: " + lastRowNum);

        int lastColumnNumber = sheet.getRow(1).getLastCellNum();
        System.out.println("Last column number: " + lastColumnNumber);

        // Looping each row
        for (int r = 0; r <= lastRowNum; r++) {
            XSSFRow row = sheet.getRow(r);
            // Looping each cell for each row
            for (int c = 0; c <lastColumnNumber; c++) {
                XSSFCell cell = row.getCell(c);

                System.out.print(cell + " | ");

            }
            System.out.println();
        }
    }
}
