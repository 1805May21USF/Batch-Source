package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	//CRUD OPERATION
		// CREATE, UPDATE , DELETE
	
	public abstract void createAccount(int Account )throws SQLException;
	
	public abstract List<Account> getAccountList() throws SQLException;
	
	public abstract void deleteAccount(int Account) throws SQLException;
	
	public abstract void updateAccount(int Account) throws SQLException;
	
}
