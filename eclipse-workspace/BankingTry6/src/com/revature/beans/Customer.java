package com.revature.beans;

public class Customer {
	private int customerID;
	private String lastName;
	public Customer() {
		super();
	}
	public Customer(int customerID, String lastName) {
		super();
		this.customerID = customerID;
		this.lastName = lastName;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return lastName;
	}
	public void setCustomerName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", lastName=" + lastName + "]";
	}
	
	
}
