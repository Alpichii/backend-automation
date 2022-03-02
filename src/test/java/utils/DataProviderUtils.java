package utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataProvider(name="DataFromExcel")
    public static Object[][] getDataFromExcelWithDataProvider(Method method){
        // Opening the exel file
        ExcelUtils.openExcelFile("petStoreData", "Sheet1");
        // Converting the list of list into multidimensional Object array
        Object[][] arrayObject = ExcelUtils.getExcelData(ExcelUtils.getValues());
        // Closing the Excel file
        ExcelUtils.closeExcelFile();

        return arrayObject;
    }
}
