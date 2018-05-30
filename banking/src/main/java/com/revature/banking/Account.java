package com.revature.banking;

import java.util.ArrayList;
import java.util.HashSet;

public class Account {
	private String accountId;
	private float accountBalance;
	private float prevAction;
	private HashSet<String> signerIDs;
	private boolean status;
	private static int idTracker = 0;
	
	Account(HashSet<String> signers){
		this( 0.0f, signers, idGenerate() );
	}
	Account(float acctBal, HashSet<String> signers){
		this(acctBal, signers, idGenerate());
	}

	Account(float acctBal, HashSet<String> signers, String acctId){
		this.setAccountId(acctId);
		this.setAccountBalance(acctBal);
		this.setSignerIDs(signers);
		this.setPrevAction(0.0f);
		this.setStatus(false);
	}
	
	
	public float getPrevAction() {
		return prevAction;
	}
	public void setPrevAction(float prevAction) {
		this.prevAction = prevAction;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	//Account()
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public HashSet<String> getSignerIDs() {
		return signerIDs;
	}
	public void setSignerIDs(HashSet<String> signerIDs) {
		this.signerIDs = signerIDs;
	}
	public void withdraw(float mon) {
		this.accountBalance = this.accountBalance - mon;
	}
	public void deposit(float mon) {
		this.accountBalance = this.accountBalance + mon;
	}
	public void transfer(String acct, float mon) {
		this.accountBalance = this.accountBalance - mon;
		for (Customer c : TechnicalDB.translateTextToArrayCu()) {
			if (c.getId().equals(acct)) {
				
			}
		}
	}
	public static String idGenerate() {
		idTracker++;
		String formatted = String.format("%03d", idTracker);
		String id = "21080"+formatted;
		return id; 
	}
	
}
