package jm.task.core.jdbc.util;

import javassist.bytecode.stackmap.BasicBlock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static String URL = "jdbc:mysql://localhost:3306/USER";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String USERNAME = "root";
    private static String PASSWORD = "000000";

    private static Connection connection;

    public static Connection getConnect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    return connection;
    }
}