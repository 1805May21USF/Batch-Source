package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Application{
	
	private int ID;
	private int fingerprint;
	private double balance;
	private String approval;
	
	private ArrayList<Customer> customers;
	
	public Application(double b,String a) {
		Random random = new Random();
		this.setFingerprint(100000000 + random.nextInt(900000000));
		this.setBalance(b);
		this.setApproval(a);
		this.customers = new ArrayList<Customer>();
	}
	public Application(int ID,int f,double b,String a) {
		this.setID(ID);
		this.setFingerprint(f);
		this.setBalance(b);
		this.setApproval(a);
		this.customers = new ArrayList<Customer>();
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String a) {
		this.approval = a;
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
	@Override
	public String toString() {
		return "Application [ID=" + ID + ", balance=" + balance+", approval=" + approval + "]";
	}
	
	public boolean removeCustomer(Customer c) {
		int toremove = -1;
		for(int i = 0;i<this.getCustomers().size();i++) {
			if(this.getCustomers().get(i).ID==c.getID()) {
				toremove = i;
			}
		}
		if(toremove != -1) {
			this.getCustomers().remove(toremove);
			System.out.println("Customer #"+c.getID()+" was removed from Application #"+this.getID());
			return true;
		}
		System.out.println("Customer #"+c.getID()+" was not a customer with Application #"+this.getID());
		return false;
	}
	public boolean addCustomer(Customer c) {
		int toremove = -1;
		for(int i = 0;i<this.getCustomers().size();i++) {
			if(this.getCustomers().get(i).ID==c.getID()) {
				toremove = i;
			}
		}
		if(toremove == -1) {
			this.getCustomers().add(c);
			return true;
		}
		return false;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public int getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(int fingerprint) {
		this.fingerprint = fingerprint;
	}
	
}
