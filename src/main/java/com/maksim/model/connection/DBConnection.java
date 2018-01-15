package com.maksim.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DBConnection {

	private  static ResourceBundle resource = ResourceBundle.getBundle("database");
	private  static String driver = resource.getString("driver");
	private  static String url = resource.getString("url");
	private  static String name = resource.getString("name");
	private static String pass = resource.getString("password");

	private static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			
			// loading the driver
			Class.forName(driver);
			
			// getting the connection
			connection = DriverManager.getConnection(url,name,pass);
			
		} catch (ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return connection;
	}
}
