package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDao {
	
	public abstract void createAccount(Account account) throws SQLException;
	public abstract void deleteAccount(int accountID) throws SQLException;
	public abstract Account getAccountByID(int accountID) throws SQLException;
	public abstract Account getAccountByClient(int clientID) throws SQLException;
	public abstract List<Account> getAllAccounts() throws SQLException;
	public abstract void deposit(Account account, double ammount) throws SQLException;
	public abstract void withdraw(Account account, double ammount) throws SQLException;
	public abstract void transfer(Account acc1, Account acc2, double amount) throws SQLException;

}
