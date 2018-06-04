package com.revature.jdbcbankproj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
private static ConnFactory cf = new ConnFactory();
	
	private ConnFactory() {
		super(); //implicit...here for best practice
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		//getConnection(jdbc:oracle:thin:urlawsendpoint:port:SID_or_DBName:, username, password)
		// hard coding is baaaad!
		// so create a database.properties file
		
		// Create Properties class. Used for loading properties values later.
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("database.properties"));
			
			try {
				Class.forName(prop.getProperty("driver"));
				
				try {
					conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
