package com.revature.BankingProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/*
 * Customer account object for managing customer information and accounts.
 */
public class CustomerAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String age;
	private String username;
	private ArrayList<UUID> bankAccountIDs;
	private ArrayList<UUID> applies;
	
	public CustomerAccount(String name, String address, String age, String username) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.username = username;
		this.bankAccountIDs = new ArrayList<UUID>();
		this.applies = new ArrayList<UUID>();
	}
	
	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ArrayList<UUID> getBankAccountIDs() {
		return bankAccountIDs;
	}
	public void setBankAccountIDs(ArrayList<UUID> bankAccountIDs) {
		this.bankAccountIDs = bankAccountIDs;
	}
	public void addBankAccountID(UUID id) {
		bankAccountIDs.add(id);
	}
	public ArrayList<UUID> getApplies() {
		return applies;
	}
	public void setApplies(ArrayList<UUID> applies) {
		this.applies = applies;
	}
	public void addApply(UUID id) {
		if (applies.contains(id))
			return;
		applies.add(id);
	}
}