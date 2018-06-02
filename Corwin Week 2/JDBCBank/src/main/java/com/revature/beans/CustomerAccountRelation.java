package com.revature.beans;

public class CustomerAccountRelation {
	
	private int id;
	private int customer_id;
	private int account_id;
	
	public CustomerAccountRelation(int cid,int aid) {
		this.setCustomer_id(cid);
		this.setAccount_id(aid);
	}
	
	public CustomerAccountRelation(int i,int cid,int aid) {
		this.setId(id);
		this.setCustomer_id(cid);
		this.setAccount_id(aid);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

}
