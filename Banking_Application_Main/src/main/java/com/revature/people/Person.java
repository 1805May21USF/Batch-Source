package com.revature.people;

public class Person {

	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String phone;
	private String username;
	private String password;
	private String SSN;
	private String account_level;
	
	protected Person(String first_name, String last_name, String address, String city, String state, String zipcode, String username, String password, String phone, String SSN) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.SSN = SSN;
		this.zipcode = zipcode;
	}

	public Person(String username, String password, String account_level) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.account_level = account_level;
	}

	public String getAccount_level() {
		return account_level;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getSSN() {
		return SSN;
	}
}
