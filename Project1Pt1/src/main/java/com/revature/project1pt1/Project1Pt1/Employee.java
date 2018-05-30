package com.revature.project1pt1.Project1Pt1;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String department;
	
	public Employee() {
		
	}
	public Employee(String firstName, String lastName, String username, String password, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.department = "Teller";
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
