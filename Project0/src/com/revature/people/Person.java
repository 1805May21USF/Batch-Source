package com.revature.people;

public abstract class Person {

	private String first_name;
	private String last_name;
	private String address;
	private int phone;
	private String username;
	private String password;
	private int SSN;
	
	protected Person(String first_name, String last_name, String address, int phone, String username, String password, int SSN) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.SSN = SSN;
	}
}
