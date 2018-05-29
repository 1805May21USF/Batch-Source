package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Application implements Serializable{
	
	private int ID;
	private Customer signer;
	private double balance;
	private ArrayList<Customer> customers;
	private String approval;
	public Application(Customer s,double b,ArrayList<Customer> c) {
		Random rnd = new Random();
		this.setID(100000 + rnd.nextInt(900000));
		this.setBalance(b);
		this.setSigner(s);
		this.setCustomers(c);
		this.setApproval("PENDING");
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String a) {
		this.approval = a;
	}
	public Customer getSigner() {
		return signer;
	}
	public void setSigner(Customer signer) {
		this.signer = signer;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
