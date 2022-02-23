package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    private static String url = "jdbc:oracle:thin:@tgbatch-3.cup7q3kvh5as.us-east-2.rds.amazonaws.com:1521/ORCL";
    private static String username = "techglobal";
    private static String password = "TechGlobal123!";

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

    public static void executeQuery(String query) {

        try {
            resultSet = connection.createStatement().executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Object getCellValue(String query) {
        // if we have only one value from one query we use this method because we don't need
        // list of list.
        return getQueryResultList(query).get(0).get(0);
    }

    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd; // we use this for getting the column size

        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(resultSet.getObject(i));
                }

                rowList.add(row);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rowList;

    }
}