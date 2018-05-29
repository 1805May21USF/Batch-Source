package com.revature.assignment0.objects;

public class QuestionSevenEmployees {
	//Private variables that are assigned during the constructor
	private String name;
	private String department;
	private byte age;
	
	//Constructor used when create a new employee object
	public QuestionSevenEmployees(String name, String department, byte age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	//Get name
	public String getName() {
		return name;
	}
	
	//Overrided the toString, so I could print out my custom message
	@Override
	public String toString() {
		return "Name: " + this.name + "\r" +
				"Department: " + this.department + "\r" +
				"Age: " + this.age + "\r";
	}
	
	//Get name
	public void setName(String name) {
		this.name = name;
	}
	
	//Get department
	public String getDepartment() {
		return department;
	}
	
	//Set department
	public void setDepartment(String department) {
		this.department = department;
	}
	
	//Get age
	public byte getAge() {
		return age;
	}
	
	//Set age
	public void setAge(byte age) {
		this.age = age;
	}
}
