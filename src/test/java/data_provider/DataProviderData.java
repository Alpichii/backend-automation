package data_provider;

import org.testng.annotations.DataProvider;

public class DataProviderData {

    @DataProvider(name = "Course")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"Java", 1},
                {"Selenium", 2},
                {"Appium", 3},
                {"SQL", 4}
        };
    }

}
