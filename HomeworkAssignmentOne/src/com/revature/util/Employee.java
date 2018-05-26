package com.revature.util;

import java.util.Comparator;

public class Employee {
	
	public String name;
	public String department;
	public int age;
	public Employee(String n,String d,int a) {
		this.name = n;
		this.department = d;
		this.age = a;
	}
	
	public String toString() {
		return "Employee: " + this.name + ", " +this.department + ", "+this.age;
		
	}
}
