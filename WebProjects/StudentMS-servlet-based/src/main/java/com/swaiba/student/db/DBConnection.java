package com.swaiba.student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DBConnection {

    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties props = new Properties();
            if (input == null) {
                throw new RuntimeException("⚠ db.properties file not found in classpath!");
            }
            props.load(input);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ DBConnection initialized.");
        } catch (IOException e) {
            System.out.println("❌ Error reading db.properties file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver not found.");
            e.printStackTrace();
        }
    }

    // Return a NEW connection each time
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
