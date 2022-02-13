package utils;

public class TestDBConnection {
    public static void main(String[] args) {


        DBUtil.createDBConnection();
        System.out.println("I can connect to the db");
    }
}
