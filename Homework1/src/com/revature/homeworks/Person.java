package com.revature.homeworks;

public class Person{
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	
	private String firstName;
	private String lastName;
	private int age;
	private String state;
	
	
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Person(String firstName, String lastName, int age, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.state = state;
	}
	
	//prints Person info
	@Override
	public String toString() {
			return "Name: "+ firstName + " " + lastName + newLine + "Age: " + age + newLine + "State: "
					+ state ;
	}
		
	
	

}
