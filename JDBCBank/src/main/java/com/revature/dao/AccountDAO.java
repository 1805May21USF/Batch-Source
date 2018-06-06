package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	//CRUD OPERATION
		// CREATE, UPDATE , DELETE
	
	public abstract void createAccount(Account account)throws SQLException;
	
	public abstract ArrayList<Account> getAccountList() throws SQLException;
	
	public abstract void deleteAccount(Account account) throws SQLException;
	
	public abstract void updateAccount(Account account) throws SQLException;
	
}
