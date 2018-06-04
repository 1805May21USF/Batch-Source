package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {

	public abstract void createAccount(double balance,
			String accountStatus, int userId) throws SQLException;

	public abstract List<Account> retrieveUserAccounts(
			int userId) throws SQLException;
	
	public abstract Account retrieveAccount(
			int accountNumber) throws SQLException;
	
	public abstract List<Account> retrieveAllAccounts() throws SQLException;

	public abstract void updateAccount(int accountNumber,
			double amount) throws SQLException;

	public abstract void deleteAccount(
			String accountNumber) throws SQLException;

}
