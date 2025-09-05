package com.pet.petadoption.db;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class DBConnection {
private static String url;
private static String user;
private static String password;
static {
	try(InputStream input=DBConnection.class.getClassLoader()
			.getResourceAsStream("db.properties")){
		Properties props=new Properties();
		if(input==null) {
			throw new RuntimeException("⚠ db.properties file not found in classpath!");
			
		}
		props.load(input);
		url=props.getProperty("db.url");
		user=props.getProperty("db.user");
		password=props.getProperty("db.password");
		Class.forName("com.mysql.cj.jdbc.Driver");
		 System.out.println("✅ DBConnection initialized.");
	}
	catch (IOException e) {
        System.out.println("❌ Error reading db.properties file.");
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        System.out.println("❌ MySQL Driver not found.");
        e.printStackTrace();
    }
}
//Return a new connection each time
public static Connection getConnection() throws SQLException {
	return DriverManager.getConnection(url,user,password);
}
}
