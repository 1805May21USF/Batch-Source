package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

/**
 * Data access object interface for bank accounts.
 * @author Nathaniel Simpson
 *
 */
public interface AccountDAO {

	/*
	 * Abstract method for creating a new bank account
	 */
	public abstract void createAccount(double balance,
			String accountStatus, int userId) throws SQLException;

	/*
	 * Abstract method for retrieving all bank accounts
	 * of a particular user.
	 */
	public abstract List<Account> retrieveUserAccounts(
			int userId) throws SQLException;
	
	/*
	 * Abstract method for retrieving a particular bank account.
	 */
	public abstract Account retrieveAccount(
			int accountNumber) throws SQLException;
	
	/*
	 * Abstract method for retrieving all bank accounts.
	 */
	public abstract List<Account> retrieveAllAccounts() throws SQLException;

	/*
	 * Abstract method updating a particular bank account.
	 */
	public abstract void updateAccount(int accountNumber,
			double amount) throws SQLException;

	/*
	 * Abstract method for deleting a particular bank account.
	 */
	public abstract void deleteAccount(
			int accountNumber) throws SQLException;

}
