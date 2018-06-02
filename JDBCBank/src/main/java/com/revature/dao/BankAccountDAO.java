package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;

public interface BankAccountDAO {
	public abstract List<BankAccount> getBankAccounts() throws SQLException;
	public abstract void createBankAccount(BankAccount acc) throws SQLException;
	public abstract void deleteBankAccount(BankAccount acc) throws SQLException;
	public abstract void updateBankAccount(BankAccount acc) throws SQLException;
}
