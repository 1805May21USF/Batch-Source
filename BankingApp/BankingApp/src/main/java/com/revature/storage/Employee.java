package com.revature.storage;

public class Employee extends Person implements java.io.Serializable{
	// the serialVersionUID for the Employee class
	private static final long serialVersionUID = 2L;
	
	// The fields stored in the Employee class
	private String department;
	private double pay;
	
	public Employee(String un, String pw, String fn, char mi, String ln, int age, String a, String d, double p) {
		super(un, pw, fn, mi, ln, age, a);
		department = d;
		pay = p;
	}
	
	// Getters and setters for the department field
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	// Getters and setters for the pay field
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	
	// Overrides the toString method in Object
	@Override
	public String toString() {
		return (getUsername() + ":" + getPassword() + ":" + getFirstName() + ":" + getMiddleInitial() + ":" + getLastName() + ":" + 
				getAge() + ":" + getAddress() + ":" + department + ":" + pay);
	}
}
