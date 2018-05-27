package com.revature.P0Banking;

public class Employee extends Account{
	private String name;
	private int age;
	private static String type = "Employee";
	
	public Employee(String username, String password, String name, int age) {
		super(username, password);
		this.name = name;
		this.age = age;
	}
	
	
}
