package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;

/*
 * Interface for bank account actions to the database.
 */
public interface BankAccountDAO {
	/*
	 * Retrieves a single account from the database using the ID.
	 */
	public BankAccount getByID(int bankAccountID) throws SQLException;
	
	/*
	 * Retrieves all of a specified customer's bank accounts.
	 */
	public List<BankAccount> getCustomerBankAccounts(int user_ID) throws SQLException;
	
	/*
	 * Retrieves all bank accounts from the database.
	 */
	public abstract List<BankAccount> getBankAccounts() throws SQLException;
	
	/*
	 * Creates a new bank account and saves it to the database.
	 */
	public abstract void createBankAccount(BankAccount acc) throws SQLException;
	
	/*
	 * Deletes an existing bank account.
	 */
	public abstract void deleteBankAccount(BankAccount acc) throws SQLException;
	
	/*
	 * Updates an existing bank account.
	 */
	public abstract void updateBankAccount(BankAccount acc) throws SQLException;
}
