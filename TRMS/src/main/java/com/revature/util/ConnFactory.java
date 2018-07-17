package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Establishes a connection to a database.
 * @author Nathaniel Simpson
 *
 */
public class ConnFactory {

	private static ConnFactory cf = new ConnFactory();

	private ConnFactory() {
		super();
	}

	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}

	public Connection getConnection(String[] arr) {
		Connection conn = null;
		//getConnection(url, username, password)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			 conn = DriverManager.getConnection(arr[0], 
                     arr[1], 
                     arr[2]);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
