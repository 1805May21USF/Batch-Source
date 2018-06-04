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
import com.revature.dao.AccountDAO;
import com.revature.util.ConnFactory;

public class AccountDAOimpl implements AccountDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	private static Scanner in = new Scanner(System.in);
	//check the client name is in the database
	
	
	public void updateBalance(Account account)throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		//ResultSet rs =
		stmt.executeQuery("UPDATE ACCOUNT SET BALANCE = " + account.getBalance() + " WHERE ACCOUNTID = " + account.getAccountNumber());
		
		conn.close();
		
			}
	
	public void createAccount(Client client) throws SQLException {
		
		System.out.println("Enter a starting Balance");
		Double balance = Double.parseDouble(in.next());
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call InsertAccount(?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, client.getClientID());
		call.setDouble(2, balance);
		call.execute();
		
		conn.close();
	}
	
public void deleteAccount(Account account) throws SQLException {
		
		if(account.getBalance()==0.00) {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call deleteAccount(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, account.getAccountNumber());
		call.execute();
		
		conn.close();
		}
		else {
			System.out.println("Withdraw all of your money before closing the account!");
		}
	}
	
		
	}
	
	

