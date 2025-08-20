package com.swaiba.student.db;
import java.sql.*;
public class DBConnection {
    private static final String url="jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC";
    private static final String user="root";
    private static final String password="Swaiba!!";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url,user,password);

    }
}
