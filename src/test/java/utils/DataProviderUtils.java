package utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataProvider(name="DataFromExcel")
    public static Object[][] getDataFromExcelWithDataProvider(Method method){
        // Opening the exel file
        ExcelUtils.openExcelFile("petStoreData", "Sheet1");
        // Converting the list of list into multidimensional Object array
        Object[][] arrayObject = ExcelUtils.getExcelData(ExcelUtils.getValues(method.getName()));
        // if method.getName() removed, check you excel table addPet need to move. if you want to run it without addPet clear and run.

        // Closing the Excel file
        ExcelUtils.closeExcelFile();

        return arrayObject;
    }
}
