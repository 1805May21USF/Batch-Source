package com.revature.accounts;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class Account {
	
	private int balance;
	private String banking_account_id;
	private int previous_transaction;

	public Account(String banking_account_id, int balance, int previous_transaction) {
		this.balance = balance;
		this.banking_account_id = banking_account_id;
		this.previous_transaction = previous_transaction;
	}
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public int getBalance() {
		return balance;
	}

	public String getBanking_account_id() {
		return banking_account_id;
	}

	public int getPrevious_transaction() {
		return previous_transaction;
	}
	
	public static boolean delete_checking_account(String account_id) {		
		try {
			
			Connection conn = cf.getConnection();
			String sql = "{call delete_checking_account (?)}";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setInt(1, Integer.parseInt(account_id));
			call.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete_joint_account(String account_id) {		
		try {
			
			Connection conn = cf.getConnection();
			String sql = "{call delete_joint_account (?)}";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setInt(1, Integer.parseInt(account_id));
			call.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete_savings_account(String account_id) {		
		try {
			
			Connection conn = cf.getConnection();
			String sql = "{call delete_saving_account (?)}";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setInt(1, Integer.parseInt(account_id));
			call.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
