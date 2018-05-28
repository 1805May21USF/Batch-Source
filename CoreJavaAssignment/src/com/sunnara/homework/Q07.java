package com.sunnara.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Sort two employees based on their name, 
 * department, and age using the Comparator interface
 */
public class Q07 implements Comparator<Employee> {
	
	ArrayList<Employee> employees;
	
	
	public Q07() {
		employees = new ArrayList<Employee>();
		Employee e1 = new Employee("Sunny P","Pega",23);
		Employee e2 = new Employee("John W","Java",28);
		employees.add(e1);
		employees.add(e2);
		
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.getAge() - e2.getAge(); 	//Compares Age
	}
	
	public void start() {
		System.out.println("Question 7:");
		System.out.println("Employee:\nName: " + employees.get(0).getName()+"\t"+employees.get(1).getName() +
				"\nAge:  " + employees.get(0).getAge()+"\t"+employees.get(1).getAge() +
				"\nDept: " + employees.get(0).getDepartment()+"\t" + employees.get(1).getDepartment());
		
		Collections.sort(employees); //Sorts using comparable in Employee class
		System.out.println("Comparing employees by name:");
		for(Employee e : employees) {
			System.out.println(e.getName());
		}
		System.out.println("Comparing employees by age:");
		Collections.sort(employees, new Q07()); //Sorts using comparator in Q07 Class
		for(Employee e : employees) {
			System.out.println(e.getName()+", " + e.getAge());
		}
		System.out.println("Comparing employees by department:");
		//Using lambda, sorted with department
		Collections.sort(employees, (e1,e2) -> {
				return e1.getDepartment().compareTo(e2.getDepartment());
			});
		for(Employee e : employees ) {
			System.out.println(e.getName() +", " + e.getDepartment());
		}
		System.out.println();
	}

}

class Employee implements Comparable<Employee>{
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

	@Override
	public int compareTo(Employee arg0) {
		return this.getName().compareTo(arg0.getName()); //Compares Name
	}
	
	
}