package com.pet.petadoption.db;
import java.io.IOException;
/**
 * Utility class for managing database connections.
 * <p>
 * This class loads database credential from{@Code db.properties} file
 * located in the classpath, initializes the MYSQL JDBC driver, and provides
 * a static method to obtain a new{@Link Connection} object whenever required.
 * </p>
 * <p><b>Usage Example:</b></p>
 * <pre>
 * try(Connection con=DBConnection.getConnection()){
 * // Use the connection for queries
 * }
 * </pre>
 * 
 * @author Swaeba
 * @version 1.0
 */
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class DBConnection {
	/** Jdbc database URL(loaded from db.properties)*/
private static String url;
/** Database username(loaded from db.properties)*/
private static String user;
/** Database password(loaded from db.properties)*/
private static String password;
//Static initializer: loads properties and JDBC driver once
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
/**Return a new connection each time
 * 
 * @return a new {@Link Connection} object
 * @throws SQLException if a database access error occurs
 */
public static Connection getConnection() throws SQLException {
	return DriverManager.getConnection(url,user,password);
}
}
