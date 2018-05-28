package com.sunnara.homework;

import java.util.Comparator;

/*
 * Sort two employees based on their name, 
 * department, and age using the Comparator interface
 */
public class Q07 implements Comparator<Employee> {
	
	public Q07() {
		Employee e1 = new Employee("Sunny P","Pega",23);
		Employee e2 = new Employee("John W","Java",28);
		compare(e1,e2);
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Employee {
	private String name;
	private String department;
	private int age;
	
	public Employee() {
		setName("Bob");
		setDepartment("Freelancer");
		setAge(42);
	}
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}