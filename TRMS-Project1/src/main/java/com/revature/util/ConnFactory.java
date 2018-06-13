package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

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

	public Connection getConnection() throws IOException {
		
		java.io.File file = new java.io.File("database.properties");
		System.out.println("Does it exist? " + file.getCanonicalPath());

		Connection conn = null;
//		java.io.File file = new java.io.File("database.properties");
//		System.out.println("Does it exist? " + file.exists());
		try {
			Scanner input = new Scanner(file);
			System.out.println("IN????" + input);
			Properties prop = new Properties();
			FileReader fr = new FileReader(file);
			prop.load(fr);
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"),
					prop.getProperty("password"));
			// getConnection(url, username, password)
			System.out.println("Loading... Please wait.");
		} catch (Exception x) {
			System.out.println("Error caught at connecting to database: " + x.getMessage());
		}

		return conn;
	}

}
