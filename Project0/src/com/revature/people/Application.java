package com.revature.people;

public class Application extends Person{

	private int claim_number;
	
	protected Application(String first_name, String last_name, String address, int phone, String username, String password, int SSN) {
		super(first_name, last_name, address, phone, username, password, SSN);

	}
	
	protected void create_application () {
		
	}

}
