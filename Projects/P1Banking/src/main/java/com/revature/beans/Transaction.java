package com.revature.beans;

import com.revature.implementdao.ImpTransactionsDAO;

public class Transaction {
	private int transactionid;
	private String type;
	private float amount;
	private int userid;
	private int accountid;
	private static final ImpTransactionsDAO itd = new ImpTransactionsDAO();
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionid, String type, float amount, int userid, int accountid) {
		super();
		this.transactionid = transactionid;
		this.type = type;
		this.amount = amount;
		this.userid = userid;
		this.accountid = accountid;
	}
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getUserid() {
		return userid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	
}
