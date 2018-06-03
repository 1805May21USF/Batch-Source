package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Account;

public interface AccountDAO {

	public abstract void createAccount(int accountNumber, double amount,
			String accountStatus, int userId) throws SQLException;

	public abstract Account retrieveAccount(int userId) throws SQLException;

	public abstract void updateAccount() throws SQLException;

	public abstract void deleteAccount() throws SQLException;

}
