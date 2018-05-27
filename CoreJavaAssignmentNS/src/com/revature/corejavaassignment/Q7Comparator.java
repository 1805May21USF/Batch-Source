package com.revature.corejavaassignment;

import java.util.Comparator;

public class Q7Comparator implements Comparator<Employee> {
	
	Employee e1 = new Employee("Gabe Newell", "Valve", 55);
	Employee e2 = new Employee("Doctor Pepper", "Roll Tide", 133);

	@Override
	public int compare(Employee o1, Employee o2) {
		
		
		
		return 0;
	}

}

class Employee {
	
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) {
		
		this.name = name;
		this.department = department;
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
	
}
