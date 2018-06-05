package com.revature.driver;
import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Account implements Serializable, AccountDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long balance;
	
	public ArrayList<BankPerson> owners = new ArrayList<BankPerson>();

	public boolean approved;
	public String type;
	
	private long accountNumber;
	public static ConnFactory cf = ConnFactory.getInstance();

	public Account() {
		
	}
	
	public Account(double balance, int number) {
		balance = 0;
		accountNumber = number;
	}
	
	public Account(BankPerson c, int number) {
		owners.add(c);
		balance = 0;
		approved = false;
		accountNumber = number;

	}
	/*
	public void addOwner(String string) {
		
		
		
		Customer c = new
		owners.add(string);
		
	
	}
	*/
	public long getBalance() {
		return balance;
	}
	
	public void withdraw(int money) {
		if(approved)
		balance-=money;
		else {
			System.out.println("Wait until an employee approves an account.");
		}
	}
	
	public void deposit(int money) {
		if(approved)
		balance += money;
		else {
			System.out.println("Wait until an employee approves an account");		
		}
	}
	
	
	public void approving(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call APPROVE(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,id);
		call.execute();
		conn.close();
		
	}
	
	public String toString() {
		if(approved) return "This account has " + balance + " dollars, whith an ID of " + accountNumber
				+  "\nand is approved.";
		else 		return "This account has " + balance + " dollars, whith an ID of " + accountNumber 
				+ "\nand is not approved.";

	}

	public void createAccount(String name, String type)  {
		
		Connection conn = cf.getConnection();
		String sql = "{call ADDACCOUNT(?,?)}";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setString(1,name);
			call.setString(2, type);
			call.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteAccount(int id) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "{call DELETEACCOUNT(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,id);
		call.execute();
		conn.close();
		
	}
	
	

/*
	public List<Account> getAccountList() throws SQLException {


		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		Statement stmt1 = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from Accounts");
				
		ResultSet rs1 = stmt1.executeQuery("Select * from Account_list");
		
		
		
		Account s = null;
		
		while(rs.next()) {
			
			
			s = new Account(rs.getInt(1),rs.getDouble(2));
			while(rs1.next()) {
				if(rs1.getInt(1) == rs.getInt(1))
					s.addOwner(rs.getString(2));
			}
			
			rs1.beforeFirst();
		}
		
		
		
		/*
		 *	public List<SuperHero> getSuperHeroList() throws SQLException {
		List<SuperHero> superHeroList = new ArrayList<SuperHero>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM SUPERHERO");
		SuperHero s = null;
		
		while(rs.next()) {
			s = new SuperHero(rs.getInt(1),rs.getString(2));
			superHeroList.add(s);
		}		
		return superHeroList;
	} 
		 
		return null;
	}

	*/

	
	public int getNewAccNumber() throws SQLException {
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT MAX(ACCOUNT_ID) FROM ACCOUNT");
		int s = 0;
		while(rs.next()) {
			s = rs.getInt(1);
		}
		
		conn.close();
		return s;
		
	}

	
	
	public List<Integer> getAccountList(String user) throws SQLException {

		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		/*
		String sql = "SELECT ACCOUNT_ID FROM ACCOUNT" + 
				"            WHERE ACCOUNT_ID = ANY" + 
				"            (SELECT ACCOUNT_ID FROM ACCOUNT_LIST" + 
				"            WHERE USERNAME = '?')";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		
		call.setString(1,user);
		*/
		
		ResultSet rs = stmt.executeQuery("SELECT ACCOUNT_ID, USERNAME FORM ACCOUNT_LIST");

		ArrayList<Integer> listt = new ArrayList<Integer>();
		
		while(rs.next() ) {
			if(rs.getString(2) == user) {
				listt.add(rs.getInt(1));
			}
		}
		/*
		ResultSet rs2;
		ArrayList<Account> listy = new ArrayList<Account>();
		for(int i = 0; i < listt.size(); i++ ) {
			
			
			rs2 = stmt.executeQuery("SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = " + Integer.toString(listt.get(i)));
			listy.add(e)
		
		}
		*/
		conn.close();
		return listt;
	}


	public static void printInfo(int account_id) throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = " + Integer.toString(account_id));
		
		rs.next();
		
		System.out.println("Account number " + rs.getInt(1) +" and it's purpose is: " + rs.getString(3) + ".");
		if(rs.getInt(4) == 1) {
			System.out.println("The account currently has " + rs.getDouble(2) + " dollars.");
		} else {
			System.out.println("It is currently NOT approved. Please wait for one of our Accountant Profesionals to approve the account.");
		}
		
		
		System.out.println();
		conn.close();
	}
	
	
	
}
