package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect2DB {

	private static Connect2DB cdb = new Connect2DB();

	private Connect2DB() {
		super();
	}
	
	public static synchronized Connect2DB getInstance() {
		if(cdb == null) {
			cdb = new Connect2DB();
		}
		return cdb;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		//.getConnection(url, username, password)
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("superuser.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), 
					prop.getProperty("usr"), prop.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
