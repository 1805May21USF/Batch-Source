package com.sunny.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import com.sunny.beans.Account;

public interface AccountDAO {
	public abstract int createAccount(int type, float balance) throws SQLException;
	public abstract ArrayList<Account> getAccountList() throws SQLException;
	public abstract Account getAccount(int aid) throws SQLException;
	public abstract void setBalance(float balance, int aid) throws SQLException;
	public abstract void deleteAccount(int aid) throws SQLException;
}
