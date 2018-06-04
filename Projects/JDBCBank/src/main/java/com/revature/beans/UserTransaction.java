package com.revature.beans;

/*
 * User transaction bean
 */
public class UserTransaction {
	private int transactionID;
	private int userID;
	private int bankAccountID;
	private String message;
	
	public UserTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTransaction(int transactionID, int userID, int bankAccountID, String message) {
		super();
		this.transactionID = transactionID;
		this.userID = userID;
		this.bankAccountID = bankAccountID;
		this.message = message;
	}
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getBankAccountID() {
		return bankAccountID;
	}
	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "UserTransaction [transactionID=" + transactionID + ", userID=" + userID + ", bankAccountID="
				+ bankAccountID + ", message=" + message + "]";
	}
}
