package com.revature.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnFactory {

	//singleton instance
	private static ConnFactory cf = new ConnFactory();

	private ConnFactory() {
		super();
		}
	
	
	public static synchronized ConnFactory getInstance() {
		if(cf == null){
			cf = new ConnFactory();
			
		}
		return cf;
		//returns a new instance if the singleton is null
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			//add the propertioes file into a variable
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("Driver"));
		//getConnection(url, username, password)
		conn = DriverManager.getConnection(prop.getProperty("url") ,prop.getProperty("usr"),prop.getProperty("password") );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}