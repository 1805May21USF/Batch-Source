package com.revature.accounts;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class Checking extends Account{
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public Checking(String banking_account_id, int balance, int previous_transaction) {
		super(banking_account_id,  balance,  previous_transaction);
	}
	
	public boolean withdraw(String banking_id, int new_balance, int old_balance) {
		try {
			Connection conn = cf.getConnection();
			
			String sql = "{call withdraw_checking_account (?,?,?)}";
			
			CallableStatement call = conn.prepareCall(sql);

			call.setInt(1,Integer.parseInt(banking_id));
			call.setInt(2, new_balance);
			call.setInt(3, old_balance);

			call.execute();
			
			return true;
		} catch (SQLException e) {
			System.out.println("Error depositing money into your account. Contact bank admin as soon as possible!");
			return false;
		}
	}
	
	public boolean deposit(String banking_id, int new_balance, int old_balance) {
		try {
			Connection conn = cf.getConnection();
			
			String sql = "{call deposit_checking_account (?,?,?)}";
			
			CallableStatement call = conn.prepareCall(sql);

			call.setInt(1,Integer.parseInt(banking_id));
			call.setInt(2, new_balance);
			call.setInt(3, old_balance);

			call.execute();
			
			return true;
		} catch (SQLException e) {
			System.out.println("Error depositing money into your account. Contact bank admin as soon as possible!");
			return false;
		}
	}
	
}
