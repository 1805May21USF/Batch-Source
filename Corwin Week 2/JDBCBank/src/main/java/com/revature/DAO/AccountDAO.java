package com.revature.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.Customer;

public interface AccountDAO {

	public abstract Account findAccount(int ID) throws SQLException;
	public abstract ArrayList<Account> findAllAccounts() throws SQLException;
	public abstract void createAccount(Account Account) throws SQLException;
	public abstract void updateAccount(Account Account) throws SQLException;
	public abstract void deleteAccount(Account Account) throws SQLException;
	Account findAccountByFingerprint(int ID) throws SQLException;
	
}
