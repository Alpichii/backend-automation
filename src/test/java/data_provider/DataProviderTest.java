package data_provider;

import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "Course", dataProviderClass = DataProviderData.class)
    public void testingTheCourse(String course, int id) {
        System.out.println(course + " : " + id);
    }

}
