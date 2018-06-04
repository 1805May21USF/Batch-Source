package com.revature.driver;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.revature.dao.SuperHero;

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
	
	
	public void approving() {
		approved = true;
	}
	
	public String toString() {
		if(approved) return "This account has " + balance + " dollars, whith an ID of " + accountNumber
				+  "\nand is approved.";
		else 		return "This account has " + balance + " dollars, whith an ID of " + accountNumber 
				+ "\nand is not approved.";

	}

	public void createAccount(String name, String type) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "{call ADDACCOUNT(?,?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,name);
		call.setString(2, type);
		call.execute();
		conn.close();
	}
	
	public void deleteAccount(String name) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "{call DELETEACCOUNT(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,name);
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


	public List<Account> getAccountList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
