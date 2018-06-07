package com.revature.beans;

public class CustomerApplicationRelation {
	
	private int id;
	private int customer_id;
	private int application_id;
	
	public CustomerApplicationRelation(int cid,int aid) {
		this.setCustomer_id(cid);
		this.setApplication_id(aid);
	}
	public CustomerApplicationRelation(int i,int cid,int aid) {
		this.setId(id);
		this.setCustomer_id(cid);
		this.setApplication_id(aid);
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

	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}


}
