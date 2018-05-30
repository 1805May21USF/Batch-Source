package com.revature.people;

public class Person {

	private String first_name;
	private String last_name;
	private String address;
	private String phone;
	private String username;
	private String password;
	private String SSN;
	
	protected Person(String first_name, String last_name, String address, String phone, String username, String password, String SSN) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.SSN = SSN;
	}

	protected String getFirst_name() {
		return first_name;
	}

	protected String getLast_name() {
		return last_name;
	}

	protected String getAddress() {
		return address;
	}

	protected String getPhone() {
		return phone;
	}

	protected String getUsername() {
		return username;
	}

	protected String getPassword() {
		return password;
	}

	protected String getSSN() {
		return SSN;
	}
}
