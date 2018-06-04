package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.beans.ConnFactory;
import com.revature.beans.Account;
import com.revature.dao.AccountDAO;

public class AccountDAOImpl implements AccountDAO {
	// Retrieves the instance of the ConnFactory class
	public static ConnFactory cf = ConnFactory.getInstance();
	private static Logger log = Logger.getLogger(AccountDAOImpl.class.getName());
	
	// Creates a customer with the entered information
	public void openAccount(int custId, Account acc) throws SQLException {
		// Retrieves the connection and provides the sql code to be executed
		Connection conn = cf.getConnection();
		String sql = "{call INSERT_BANK_ACCOUNT(?, ?, ?, ?, ?)";
		
		// Instantiates a CallableStatement to insert a new account
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, custId);
		call.setString(2, acc.getType());
		call.setString(3, acc.getName());
		call.setDouble(4, acc.getBalance());
		call.setInt(5, acc.getShared());
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully created account number " + acc.getId() + " named " + acc.getName() + " for customer number + " + custId + "\n");
	}
	
	// Retrieves a list of all accounts
	public ArrayList<Account> listAccounts(int arg) throws SQLException {
		// Instantiates the list to be returned
		ArrayList<Account> accountList = new ArrayList<>();
		Connection conn = cf.getConnection();
			
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE CUSTOMERID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
			
		stmt.setInt(1, arg);
			
		ResultSet rs = stmt.executeQuery();
			
		// Puts the retrieved accounts into the list
		while(rs.next()) {
			Account a = new Account(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
				
			accountList.add(a);
		}
			
		// Closes the database connection
		conn.close();
			
		// Returns the list
		return accountList;
	}
	
	public ArrayList<Account> listAccounts(String arg) throws SQLException {
		// Instantiates the list to be returned
		ArrayList<Account> accountList = new ArrayList<>();
		Connection conn = cf.getConnection();
			
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE CUSTOMERID > ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
			
		stmt.setInt(1, Integer.parseInt(arg));
			
		ResultSet rs = stmt.executeQuery();
			
		// Puts the retrieved accounts into the list
		while(rs.next()) {
			Account a = new Account(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
				
			accountList.add(a);
		}
			
		// Closes the database connection
		conn.close();
			
		// Returns the list
		return accountList;
	}
	
	public ArrayList<Account> listAccounts(int argOne, int argTwo) throws SQLException{
		// Instantiates the list to be returned
		ArrayList<Account> accountList = new ArrayList<>();
		Connection conn = cf.getConnection();
				
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE CUSTOMERID = ? OR SHARED_ACCOUNT = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
				
		stmt.setInt(1, argOne);
		stmt.setInt(2, argTwo);
			
		ResultSet rs = stmt.executeQuery();
				
		// Puts the retrieved accounts into the list
		while(rs.next()) {
			Account a = new Account(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
					
			accountList.add(a);
		}
				
		// Closes the database connection
		conn.close();
				
		// Returns the list
		return accountList;
	}
	
	public ArrayList<Account> listAccounts(int argOne, double argTwo) throws SQLException{
		// Instantiates the list to be returned
		ArrayList<Account> accountList = new ArrayList<>();
		Connection conn = cf.getConnection();
				
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE CUSTOMER ID = ? AND BALANCE = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
				
		stmt.setInt(1, argOne);
		stmt.setDouble(2, argTwo);
			
		ResultSet rs = stmt.executeQuery();
				
		// Puts the retrieved accounts into the list
		while(rs.next()) {
			Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
					
			accountList.add(a);
		}
				
		// Closes the database connection
		conn.close();
				
		// Returns the list
		return accountList;
	}

	// Deletes an account whose id number was provided
	public void closeAccount(int id) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call DELETE_BANK_ACCOUNT(?)";
		
		// Instantiates a CallableStatement to delete the account whose id was entered
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, id);
		
		// Executes call
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully closed account number + " + id + "\n");
	}
	
	// Updates the account information of the entered account
	public void updateAccount(int id, int custId, String type, String name, double balance, int shared) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call UPDATE_BANK_ACCOUNT(?, ?, ?, ?, ?, ?)";
		
		// Instantiates a CallableStatement to update the account with the entered information
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, id);
		call.setInt(2, custId);
		call.setString(3, type);
		call.setString(4, name);
		call.setDouble(5, balance);
		call.setInt(6, shared);
		call.execute();
		
		// Executes call
		call.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully updated account " + name + " belonging to customer number " + custId + "\n");
	}
	
	// Withdraws a provided amount of money from a provided account
	public void withdraw(int id, double amount) throws SQLException{
		// Opens a connection to the database and prepares the necessary statement to withdraw money from the account
		Connection conn = cf.getConnection();
		String sql = "{call WITHDRAW_BANK_ACCOUNT(?, ?)";
		
		// Updates the account money was withdrawn from
		CallableStatement stmt = conn.prepareCall(sql);
		stmt.setInt(1, id);
		stmt.setDouble(2, amount);
		stmt.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully withdrew from account number " + id + ", new total is $" + amount + "\n");
	}
	
	// Deposits a provided amount of money into a provided account
	public void deposit(int id, double amount) throws SQLException{
		// Opens a connection to the database and prepares the necessary statement to deposit money into the account
		Connection conn = cf.getConnection();
		String sql = "{call DEPOSIT_BANK_ACCOUNT(?, ?)";
		
		// Updates the account money was deposited into
		CallableStatement stmt = conn.prepareCall(sql);
		stmt.setInt(1, id);
		stmt.setDouble(2, amount);
		stmt.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully deposited into account number " + id + ", which has a new balance of $" + amount + "\n");
	}
	
	// Transfers a provided amount of money from the first account provided to the second account provided
	public void transfer(int idOne, int idTwo, double amountOne, double amountTwo) throws SQLException{
		// Creates a connection to the database and prepares the necessary sql statements to transfer money from one account to the other
		Connection conn = cf.getConnection();
		String sqlOne = "{call TRANSFER_BANK_ACCOUNT(?, ?, ?, ?)";
		
		// Updates the account where money is being transfered from
		CallableStatement stmt = conn.prepareCall(sqlOne);
		stmt.setInt(1, idOne);
		stmt.setDouble(2, amountOne);
		stmt.setInt(3, idTwo);
		stmt.setDouble(4, amountTwo);
		stmt.execute();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully transferred from account number " + idOne + ", now with a total balance of $" + amountOne + " into account number " + idTwo + 
				 ", now with a total balance of $" + amountTwo + "\n");
	}
}
