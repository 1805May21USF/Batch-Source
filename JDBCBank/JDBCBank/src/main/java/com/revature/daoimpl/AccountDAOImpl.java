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
	private static Logger log = Logger.getLogger(Account.class.getName());
	
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
	public ArrayList<Account> listAccounts(String arg) throws SQLException {
		// Instantiates the list to be returned
		ArrayList<Account> accountList = new ArrayList<>();
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM ACCOUNT WHERE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		if(!arg.equals("n"))
			stmt.setString(1, arg);
		else
			stmt.setString(1, "ACCOUNTID > 0");
		
		ResultSet rs = stmt.executeQuery();
		
		// Puts the retrieved accounts into the list
		while(rs.next()) {
			Account a = new Account(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			
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
		String sql = "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE ACCOUNTID = ?";
		
		// Updates the account money was withdrawn from
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, amount);
		stmt.setInt(2, id);
		stmt.executeUpdate();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully withdrew $" + amount + " from account number " + id + "\n");
	}
	
	// Deposits a provided amount of money into a provided account
	public void deposit(int id, double amount) throws SQLException{
		// Opens a connection to the database and prepares the necessary statement to deposit money into the account
		Connection conn = cf.getConnection();
		String sql = "UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE ACCOUNTID = ?";
		
		// Updates the account money was deposited into
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, amount);
		stmt.setInt(2, id);
		stmt.executeUpdate();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully deposited $" + amount + " from account number " + id + "\n");
	}
	
	// Transfers a provided amount of money from the first account provided to the second account provided
	public void transfer(int idOne, int idTwo, double amount) throws SQLException{
		// Creates a connection to the database and prepares the necessary sql statements to transfer money from one account to the other
		Connection conn = cf.getConnection();
		String sqlOne = "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE ACCOUNTID = ?";
		String sqlTwo = "UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE ACCOUNTID = ?";
		
		// Updates the account where money is being transfered from
		PreparedStatement stmtOne = conn.prepareStatement(sqlOne);
		stmtOne.setDouble(1, amount);
		stmtOne.setInt(2, idOne);
		stmtOne.executeUpdate();
		
		// Updates the account money is being transfered to
		PreparedStatement stmtTwo = conn.prepareStatement(sqlTwo);
		stmtTwo.setDouble(1, amount);
		stmtTwo.setInt(2, idTwo);
		stmtTwo.executeUpdate();
		
		// Closes the database connection
		conn.close();
		
		log.info("Info:\nSuccessfully transferred $" + amount + " from account number " + idOne + " into account number " + idTwo + "\n");
	}
}
