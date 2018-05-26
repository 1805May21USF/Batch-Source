package com.revature.toomuchhw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Q7. Sort two employees based on their name, department, and age using the Comparator interface.
public class Problem7{
	//Nested classes make my head hurt.
	public class Employee{
		private String name;
		private String department;
		private int age;
		
		public Employee(String name, String department, int age) {
			super();
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
	//Two Employee Objects to compare
	private Employee a = new Employee("Batman", "Crimefighting", 40);
	private Employee b = new Employee("Oracle", "Strategy", 30);
	
	//Comparator classes
	public class CompareName implements Comparator<Employee>{
		@Override
		public int compare(Employee a, Employee b) {
			return a.name.compareTo(b.name);
		}
	}
	public class CompareDepartment implements Comparator<Employee>{
		@Override
		public int compare(Employee a, Employee b) {
			return a.department.compareTo(b.department);
		}
	}
	public class CompareAge implements Comparator<Employee>{
		@Override
		public int compare(Employee a, Employee b) {
			return a.getAge()-b.getAge();
		}
	}
	
	//Comparing Methods
	public ArrayList<Employee> compareNames() {
		ArrayList<Employee> ab = new ArrayList<Employee>();
		ab.add(a);
		ab.add(b);
		
		Collections.sort(ab, new CompareName());
		return ab;
	}
	public ArrayList<Employee> compareDepartment() {
		ArrayList<Employee> ab = new ArrayList<Employee>();
		ab.add(a);
		ab.add(b);
		
		Collections.sort(ab, new CompareDepartment());
		return ab;
	}
	public ArrayList<Employee> compareAge() {
		ArrayList<Employee> ab = new ArrayList<Employee>();
		ab.add(a);
		ab.add(b);
		
		Collections.sort(ab, new CompareAge());
		return ab;
	}
}

