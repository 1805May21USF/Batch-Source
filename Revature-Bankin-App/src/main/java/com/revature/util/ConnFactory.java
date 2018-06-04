package com.revature.util;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

	public class ConnFactory {
		

		private static ConnFactory cf = new ConnFactory();


		private ConnFactory() {
			super();
			}
		
		//an instance of the connFactory singleton
		public static synchronized ConnFactory getInstance() {
			if(cf == null){
				cf = new ConnFactory();
				
			}
			return cf;
		}
		//method to obtain a connection
		public Connection getConnection() {
			Connection conn = null;
			try {
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
	

