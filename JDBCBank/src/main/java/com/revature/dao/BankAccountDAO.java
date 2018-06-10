package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.banking_app.BankAccount;

public interface BankAccountDAO 
{
	public abstract void createBankAccount(BankAccount bankAccount) throws SQLException;
	public abstract void updateBankAccount(BankAccount bankAccount) throws SQLException;
	public abstract void updateBalance(BankAccount bankAccount) throws SQLException;
	public abstract void deleteBankAccount(BankAccount bankAccount) throws SQLException;
	public abstract ArrayList<BankAccount> getBankAccountsOwnedByUser(String userLoginName) throws SQLException;
	public abstract ArrayList<BankAccount> getBankAccounts() throws SQLException;
}
