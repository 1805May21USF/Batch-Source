package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Client;
import com.revature.util.ConnFactory;

public class SuperUserDAOimpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	private static Scanner in = new Scanner(System.in);
	
	
	
	public List<Account> getAllAccounts()throws SQLException{
		
		
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		Account a = null;
			while(rs.next()) {
			a = new Account(rs.getInt(1),rs.getInt(2),rs.getDouble(3));
				accountList.add(a);
			}
			conn.close();
		
		return accountList;
	}
	
public void createAccount() throws SQLException {
		
		System.out.println("Enter the clients ID");
		int clientID = Integer.parseInt(in.next());
		System.out.println("Enter a starting Balance");
		Double balance = Double.parseDouble(in.next());
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call InsertAccount(?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, clientID);
		call.setDouble(2, balance);
		call.execute();
		
		conn.close();
	}
}
