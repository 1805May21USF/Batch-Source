package com.revature.util;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class ConnFactory {
	// Create an instance
	private static ConnFactory cf = new ConnFactory();

	// Create a private constructor

	private ConnFactory() {
		super();
	}

	// Create a private 
	public static synchronized ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
			//getConnection(url, username, password)
			System.out.println("Loading... Please wait.");
        } catch (Exception x) {
            System.out.println("Error caught at connecting to database: " + x.getMessage());
        }
		
		return conn;
	}
	
}
