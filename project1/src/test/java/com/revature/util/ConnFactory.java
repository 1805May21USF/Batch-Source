package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.proxy.annotation.GetProxy;

public class ConnFactory {
	private static ConnFactory cf = new ConnFactory();

	public static synchronized ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		return cf;		
	}
	public Connection getConnection() {
		Connection con = null;
		Properties connectionProperties = new Properties();
		try {
			connectionProperties.load(new FileReader("database.properties"));
			Class.forName(connectionProperties.getProperty("driver"));
			System.out.println(" res is :"+ connectionProperties.getProperty("url")+ " " +connectionProperties.getProperty("user")+ " " +connectionProperties.getProperty("password"));

			con=DriverManager.getConnection(connectionProperties.getProperty("url"),connectionProperties.getProperty("user"),connectionProperties.getProperty("password") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
} 

