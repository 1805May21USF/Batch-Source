package com.revature.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Transaction;

public class TransactionSerializer implements TransactionDAO{


	private ArrayList<Transaction> transactions;
	
	public TransactionSerializer() {
		this.transactions = new ArrayList<Transaction>();
	}
	
	@Override
	public ArrayList<Transaction> getAllTransaction() {
		loadFromFile();
		return this.transactions;
	}

	@Override
	public Transaction getTransaction(int ID) {
		loadFromFile();
		for(Transaction transaction: this.transactions) {
			if(ID == transaction.getID()) {
				return transaction;
			}
		}
		return null;
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		loadFromFile();
		if(getTransaction(transaction.getID())!=null) {
			deleteTransaction(transaction);
		}
		this.transactions.add(transaction);
		saveToFile();
	}

	@Override
	public void deleteTransaction(Transaction transaction) {
		loadFromFile();
		this.transactions.remove(transaction);
		saveToFile();
		
	}
	
	public void loadFromFile() {
		try {
			
			ObjectInputStream objectInputStream =
				    new ObjectInputStream(new FileInputStream("TransactionsTable.txt"));
			
			this.transactions = (ArrayList<Transaction>) objectInputStream.readObject();
			for(Transaction i:this.transactions) {
				System.out.println(i);
			}

			objectInputStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Could not read from file!");
		} catch (ClassNotFoundException e) {
			System.out.println("The data in the file was not the class provided!");
		} 
			catch (NullPointerException e) {
			System.out.println("There was no data!");
		}
	}
	
	public void saveToFile() {
		try {
			ObjectOutputStream objectOutputStream =
			        new ObjectOutputStream(new FileOutputStream("TransactionsTable.txt"));
			
			objectOutputStream.writeObject(transactions);
	        objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Couldn't write to file!");
		}
	}
}
