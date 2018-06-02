package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;

public interface BankAccountDAO {
	public abstract void createBankAccount(int userid) throws SQLException;
	public abstract void updateBankAccount(BankAccount b) throws SQLException;
	public abstract void deleteBankAccount(int accountid) throws SQLException;
	public abstract List<BankAccount> getUserBankAccounts(int userid) throws SQLException;
	public abstract List<BankAccount> getBankAccountList() throws SQLException;
}
