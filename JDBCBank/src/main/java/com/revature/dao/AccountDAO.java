package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;


//CRUD - create, retrieve, update delete
public interface AccountDAO {
	
		//Create a new account
		public abstract void addAccount(String username, double initAmount) throws SQLException;
		
		//get the user_id from the Usertable to add to the account table
		public abstract int getUserId(String username) throws SQLException;
				
		//retrieve an account with their account number
		public abstract Account getAccount(int accId) throws SQLException;
		
		//retrieve a list of accounts
		public abstract List<Account> getAccounts(String username) throws SQLException;
		
		//retrieve accountbalance from username
		public abstract double getAccountBal(String username, int accountId) throws SQLException;
		
		//getting account_id from user_id 
		public abstract int getAccountId(int userId) throws SQLException;
		
		//update a account balance from username and accountid
		public abstract void updateAccountBal(String username, double amount, int accountId) throws SQLException;
		
		//delete an account with their username and account number
		public abstract void deleteAccount(String username , int accountId) throws SQLException;

}
