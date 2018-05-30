package com.revature.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Transaction implements Serializable {
	
	private int ID;
	private Date date;
	private String status;
	private String type;
	private Account account;
	private Account reciever;
	private double amount;
	private double balance;

	public Transaction(String t,Account a, double am, double b) {
		Random rnd = new Random();
		this.setID(100000 + rnd.nextInt(900000));
		this.setDate(new Date());
		this.setStatus("APPROVED");
		this.setAccount(a);
		this.setAmount(am);
		this.setBalance(b);
		this.setType(t);
		
		
	}
	
	public Transaction(String t,Account a, Account r, double am, double b) {
		Random rnd = new Random();
		this.setID(100000 + rnd.nextInt(900000));
		this.setDate(new Date());
		this.setStatus("APPROVED");
		this.setAccount(a);
		this.setReciever(r);
		this.setAmount(am);
		this.setBalance(b);
		this.setType(t);
	}
	
	

	@Override
	public String toString() {
		return "Transaction [ID=" + ID + ", date=" + date + ", status=" + status + ", type=" + type + ", account="
				+ account + ", reciever=" + reciever + ", amount=" + amount + ", balance=" + balance + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getReciever() {
		return reciever;
	}

	public void setReciever(Account reciever) {
		this.reciever = reciever;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
