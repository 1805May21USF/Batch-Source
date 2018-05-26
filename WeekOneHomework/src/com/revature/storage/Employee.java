/****************************************************
 * 		Name: Employee								*
 * 		Purpose: An Employee object that stores an  *
 * 				 employee's name, age, and 			*
 * 				 department
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.storage;

public class Employee{
	private String name;
	private String department;
	private int age;

	// Getter and setter methods for the name variable
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter and setter methods for the department variable
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	// Getter and setter methods for the age variable
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Converts the Employee object into a String object
	@Override
	public String toString() {
		return "Employee[name=" + name + ", department=" + department + ", age= " + age + "]";
	}
}
