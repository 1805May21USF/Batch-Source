package com.revature.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Customer;
import com.revature.beans.Transaction;

public interface TransactionDAO {
	
	public abstract Transaction findTransaction(int ID) throws SQLException;
	public abstract ArrayList<Transaction> findAllTransactions() throws SQLException;
	public abstract void createTransaction(Transaction Transaction) throws SQLException;
	public abstract void updateTransaction(Transaction Transaction) throws SQLException;
	public abstract void deleteTransaction(Transaction Transaction) throws SQLException;

}
