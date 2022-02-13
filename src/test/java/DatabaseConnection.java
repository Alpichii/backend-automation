import org.testng.Assert;

import java.sql.*;

public class DatabaseConnection {

    public static void main(String[] args) throws SQLException {
        // This is the interview question regarding how to connect database in your automation
        String url = "jdbc:oracle:thin:@tgbatch-3.cup7q3kvh5as.us-east-2.rds.amazonaws.com:1521/ORCL";
        String username = "techglobal";
        String password = "TechGlobal123!";
        String query = "select * from employees";

        // Creating the  connection to database with the parameters
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("System should be able to connect to the database");
        // Statement keeps the connection between my machine and database
        Statement statement = connection.createStatement();
        // Sending the query to database
        ResultSet resultSet = statement.executeQuery(query);

//        ResultSetMetaData interface is helping us to get the table info
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        System.out.println("Number of column: " + resultSetMetaData.getColumnCount());
        System.out.println("Name of the first column: "+resultSetMetaData.getColumnName(1));
        System.out.println(" "+ resultSetMetaData.getColumnDisplaySize(1));

//
//
        System.out.println(" First Name                Last Name"  );
        while (resultSet.next()) {
            String firstName = resultSet.getString("FIRST_NAME");
            String lastName = resultSet.getString("LAST_NAME");
            System.out.println(firstName+ "                "+ lastName);

            if(firstName.equals("Steven")){
                String actualName= firstName;
                Assert.assertEquals(actualName, "Steven");
                System.out.println("Actual name: "+ actualName);
                break;
            }



        }


    }
}
