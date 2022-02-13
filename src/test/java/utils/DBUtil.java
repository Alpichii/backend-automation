package utils;

import java.sql.*;

public class DBUtil {
    private static String url = "jdbc:oracle:thin:@tgbatch-3.cup7q3kvh5as.us-east-2.rds.amazonaws.com:1521/ORCL";
    private static String username = "techglobal";
    private static String password = "TechGlobal123!";
    private static String query = "select * from employees";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static Connection createDBConnection() {

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("User connected to the database");
        } catch (SQLException e) {
            System.out.println("Database connection if failed");
            e.printStackTrace();
        }
        return connection;
    }


}
