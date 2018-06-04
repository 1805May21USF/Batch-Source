package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;


public interface AccountDAO {
	
	public abstract void createAccount(int userID,float balance) throws SQLException;
	//public List<SuperHero> getSuperHeroList() throws SQLException
	public abstract List<Account> getUserAccountsList(int userID) throws SQLException;
	/*public abstract boolean withdraw(int userID,float amount) throws SQLException;
	public abstract boolean deposit(int userID,float amount) throws SQLException;
	public abstract boolean deleteAccount(int accountID) throws SQLException;
*/
}
