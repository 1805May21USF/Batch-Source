package com.revature.beans;

/**
 * Class for creating user account objects.
 * @author Nathaniel Simpson
 *
 */
public class User {
	
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private int status; // 0=pending approval 1=customer, 2=employee, 3=admin
	
	// Default constructor
	public User() {
		super();
	}

	// Constructor
	public User(int id, String userName, String firstName, String lastName,
			String password, int status) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", status=" + status + "]";
	}

}
