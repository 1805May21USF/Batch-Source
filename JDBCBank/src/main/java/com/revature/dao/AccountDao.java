package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;

public interface AccountDao {
	public abstract void createAccount(double accountBalance, int accountNumber) throws SQLException;
	public abstract Account readAccount(String Username, String Password, int accountNumber) throws SQLException;
	public abstract void updateAccount(String Username, String Password, Account account, double number) throws SQLException;	
	public abstract void deleteAccount(String Username, String Password) throws SQLException;
	public abstract List<Account> getAccount() throws SQLException;
}
