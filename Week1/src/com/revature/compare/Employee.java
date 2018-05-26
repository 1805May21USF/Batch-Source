package com.revature.compare;

public class Employee implements Comparable<Employee>{
	public String name;
	public String dept;
	public int age;
	@Override
	public int compareTo(Employee arg0) {

		return name.compareTo(arg0.name) + dept.compareTo(arg0.dept) + age-arg0.age;
	}
	public Employee(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	
}
