package com.revature.beans;

public class Employee {

	private String name;
	private String department;
	private int age;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "Employee Name: " + this.name + " Department: " + this.department + " Age: " + this.age;
	}
}
