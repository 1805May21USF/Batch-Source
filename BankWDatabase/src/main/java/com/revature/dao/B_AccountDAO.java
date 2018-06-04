package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.B_Account;

public interface B_AccountDAO {
//CRUD operations
	public abstract void createBankAccount(float acctBal, int makerID) throws SQLException;
	public abstract List<B_Account> getBankAccountList() throws SQLException;
	public abstract List<B_Account> getMyAccountList(int uID) throws SQLException;
	
}
