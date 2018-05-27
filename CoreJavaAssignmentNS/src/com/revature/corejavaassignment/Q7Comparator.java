package com.revature.corejavaassignment;

import java.util.Arrays;
import java.util.Comparator;

public class Q7Comparator extends Employee {
	
	private static Employee e1 = new Employee("Gabe Newell", "Valve", 55);
	private static Employee e2 = new Employee("Mr. Pibb", "Roll Tide", 133);
	private static Employee[] employees = {e1, e2};
	
	public Q7Comparator(String name, String department, int age) {
		super(name, department, age);
	}
	
	public static void comparatorDemo() {
		
		CompareName compareName = new CompareName();
		CompareDepartment compareDepartment = new CompareDepartment();
		CompareAge compareAge = new CompareAge();
		
		System.out.println("Q7. Comparator");
		
		Arrays.sort(employees, compareName);
		System.out.println("\tSorted by name:");
		printEmployees();
		
		Arrays.sort(employees, compareDepartment);
		System.out.println("\tSorted by department:");
		printEmployees();
		
		Arrays.sort(employees, compareAge);
		System.out.println("\tSorted by age:");
		printEmployees();
		
	}
	
	public static void main(String[] args) {
		comparatorDemo();
	}
	
	private static void printEmployees() {
		for (Employee e : employees) {
			System.out.println("\t\t[Name: " + e.getName() + ", Department: "
					+ e.getDepartment() + ", Age: " + e.getAge() + "]");
		}
		System.out.println();
	}

}

class CompareDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		if (employee1.getDepartment().compareTo(employee2.getDepartment()) > 0)
			return 1;
		if (employee1.getDepartment().compareTo(employee2.getDepartment()) < 0)
			return -1;
		return 0;
	}
	
}

class CompareName implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		if (employee1.getName().compareTo(employee2.getName()) > 0)
			return 1;
		if (employee1.getName().compareTo(employee2.getName()) < 0)
			return -1;
		return 0;
	}
	
}

class CompareAge implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		if (employee1.getAge() > employee2.getAge())
			return 1;
		if (employee1.getAge() < employee2.getAge())
			return -1;
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

	public String toString() {
		String employee = "[Name: " + name + ", Department: " + department +  ", Age: " + age;
		return employee;
	}
	
}
