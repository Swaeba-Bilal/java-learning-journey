package com.swaiba.student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();
                InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");

                if (input == null) {
                    throw new RuntimeException("⚠ db.properties file not found in classpath!");
                }

                props.load(input);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                // Explicitly load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("✅ Database connection established.");

            } catch (IOException e) {
                System.out.println("❌ Error reading db.properties file.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("❌ Database connection failed.");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("❌ MySQL Driver not found. Did you add the JAR?");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
