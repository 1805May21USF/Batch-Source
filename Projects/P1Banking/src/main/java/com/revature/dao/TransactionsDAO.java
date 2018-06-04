package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Transaction;

public interface TransactionsDAO {
	public abstract void addTransaction(String type, float amount, int accountid, int userid) throws SQLException;
	public abstract List<Transaction> getUserTransactions(int userid) throws SQLException;
	public abstract List<Transaction> getAllTransactions() throws SQLException;
}
