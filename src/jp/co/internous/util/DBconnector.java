package jp.co.internous.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/";
    private static String DB = "test"; // データベース名
    private static String URLplusDB = URL.concat(DB);

    private static String user = "root";
    private static String pass = "mysql";
    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(URLplusDB,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}