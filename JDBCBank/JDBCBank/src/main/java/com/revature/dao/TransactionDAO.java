package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Transaction;

public interface TransactionDAO {
	public abstract void addTransaction(Transaction t) throws SQLException;
	public abstract ArrayList<Transaction> listTransactions(String arg) throws SQLException;
}
