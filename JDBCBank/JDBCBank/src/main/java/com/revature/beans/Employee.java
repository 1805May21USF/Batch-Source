package com.revature.beans;

public class Employee extends User {
	
	private int employeeID;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int userID, String firstName, String lastName, String email, String username, String password) {
		super(userID, firstName, lastName, email, username, password);
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeID) {
		super();
		this.employeeID = employeeID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	

}
