package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Account;

public interface AccountDAO {

	public abstract void createAccount(int accountNumber, double balance,
			String accountStatus, int userId) throws SQLException;

	public abstract Account retrieveAccount(int userId) throws SQLException;

	public abstract void updateAccount(int accountNumber,
			double amount) throws SQLException;

	public abstract void deleteAccount() throws SQLException;

}
