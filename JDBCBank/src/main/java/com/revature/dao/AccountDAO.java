package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {

	public abstract List<Account> getUserAccount(int userID) throws SQLException;
	public abstract void createAccount(int userID) throws SQLException;
	public abstract void updateAccount(Account ac, float balance) throws SQLException;
	public abstract void deleteAccount(Account ac) throws SQLException;
}
