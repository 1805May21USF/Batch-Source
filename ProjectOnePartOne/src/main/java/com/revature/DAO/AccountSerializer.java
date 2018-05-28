package com.revature.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Account;

public class AccountSerializer implements AccountDAO{
	

	private ArrayList<Account> accounts;
	
	public AccountSerializer() {
		this.accounts = new ArrayList<Account>();
	}
	
	@Override
	public ArrayList<Account> getAllAccount() {
		loadFromFile();
		return this.accounts;
	}

	@Override
	public Account getAccount(int ID) {
		loadFromFile();
		for(Account account: this.accounts) {
			if(ID == account.getID()) {
				return account;
			}
		}
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		loadFromFile();
		if(getAccount(account.getID())!=null) {
			deleteAccount(account);
		}
		this.accounts.add(account);
		saveToFile();
	}

	@Override
	public void deleteAccount(Account account) {
		loadFromFile();
		this.accounts.remove(account);
		saveToFile();
		
	}
	
	public void loadFromFile() {
		try {
			
			ObjectInputStream objectInputStream =
				    new ObjectInputStream(new FileInputStream("AccountsTable.txt"));
			
			this.accounts = (ArrayList<Account>) objectInputStream.readObject();
			for(Account i:this.accounts) {
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
			        new ObjectOutputStream(new FileOutputStream("AccountsTable.txt"));
			
			objectOutputStream.writeObject(accounts);
	        objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Couldn't write to file!");
		}
	}

}
