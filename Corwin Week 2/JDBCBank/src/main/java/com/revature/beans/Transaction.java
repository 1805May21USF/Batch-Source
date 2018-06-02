package com.revature.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Transaction{
	
	private int ID;
	private String date;
	private String status;
	private String type;
	private int from_account_id;
	private int to_account_id;
	private double amount;
	private double balance;
	
	public Transaction(String d,String s,String t,int f,int to,int a, double am, double b) {
		this.setDate(d);
		this.setStatus(s);
		this.setType(t);
		this.setFrom_account_id(f);
		this.setTo_account_id(to);
		this.setAmount(am);
		this.setBalance(b);
		this.setType(t);
		
		
	}

	public Transaction(int ID, String d,String s,String t,int f,int to,int a, double am, double b) {
		this.setID(ID);
		this.setDate(d);
		this.setStatus(s);
		this.setType(t);
		this.setFrom_account_id(f);
		this.setTo_account_id(to);
		this.setAmount(am);
		this.setBalance(b);
		this.setType(t);
		
		
	}
	@Override
	public String toString() {
		return "Transaction [ID=" + ID + ", date=" + date + ", status=" + status + ", type=" + type + ", account="
				+ from_account_id + ", reciever=" + to_account_id + ", amount=" + amount + ", balance=" + balance + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String d) {
		this.date = d;
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
	
	public int getFrom_account_id() {
		return from_account_id;
	}
	public void setFrom_account_id(int from_account_id) {
		this.from_account_id = from_account_id;
	}
	public int getTo_account_id() {
		return to_account_id;
	}
	public void setTo_account_id(int to_account_id) {
		this.to_account_id = to_account_id;
	}
	
}
