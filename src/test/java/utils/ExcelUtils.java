package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static String excelFilePath;

    public static void openExcelFile(String excelFileName, String sheetName) {
        excelFileName = "testData/" + excelFileName + ".xlsx";

        try {
            FileInputStream fileInputStream = new FileInputStream(excelFileName);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
            System.out.println("The file and sheet exist!");
        } catch (Exception e) {
            System.out.println("The file is not exist!");
        }
    }

    public static void main(String[] args) {
        openExcelFile("excelSample", "Sheet1");
    }

}
