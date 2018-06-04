package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.UserTransaction;

public interface UserTransactionDAO {
	/*
	 * Retrieves all of the user transactions from the database.
	 */
	public abstract List<UserTransaction> getUserTransactions(UserTransaction ut) throws SQLException;
	
	/*
	 * Creates a new user transaction and saves to the database.
	 */
	public abstract void createUserTransaction(UserTransaction ut) throws SQLException;
}
