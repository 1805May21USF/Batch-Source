package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {
	// Declares the abstract methods that need to be implemented by a class
	public abstract void openAccount(int custId, Account acc) throws SQLException;
	public abstract List<Account> listAccounts(String arg) throws SQLException;
	public abstract void closeAccount(int id) throws SQLException;
	public abstract void withdraw(int id, double amount) throws SQLException;
	public abstract void deposit(int id, double amount) throws SQLException;
	public abstract void transfer(int idOne, int idTwo, double amount) throws SQLException;
}
