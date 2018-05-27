package com.revature.P0Banking;

import java.io.Serializable;

public class Customer extends Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private static String type = "Customer";

	public Customer(String name, int age, String username, String password) {
		super(username, password);
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void viewAccount() {
		// TODO Auto-generated method stub
		System.out.println("Things are exploding");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		Customer.type = type;
	}

	
	
}
