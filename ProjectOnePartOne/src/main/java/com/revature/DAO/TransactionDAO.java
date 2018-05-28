package com.revature.DAO;

import java.util.ArrayList;

import com.revature.beans.Transaction;

public interface TransactionDAO {
	   public ArrayList<Transaction> getAllTransaction();
	   public Transaction getTransaction(int ID);
	   public void updateTransaction(Transaction transaction);
	   public void deleteTransaction(Transaction transaction);
}
