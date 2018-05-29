package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

public class Q07Employee implements Comparator<Object> {
	
	
	
	
	
	
	private int age;
	private String Department;
	private String Name;
	

	
	public Q07Employee(int age, String Name, String Department) {
		this.age = age;
		this.Name = Name; 
		this.Department = Department;
	}
	

	//This compare function is the only function you should really care about in this 
	//class. The way it works is if you want to age, Department, or Name, the type is
	//1, 2, and 3 respectively.
	
	//If the greater one is first, the return is 1, otherwise it is 0.
	public int compare(Q07Employee e1, Q07Employee e2, int type) {

		
		if(type == 1) {
			if (e1.age>e2.age) return 1;
			else return 0;
		}
		if(type == 2) {
			if((e1.Department.compareTo(e2.Department)) < 0) return 1;	
			else return 0;
		}
		if(type == 3) {
			if((e1.Name.compareTo(e2.Name)) < 0) return 1;
			else return 0;
		}
		
		return 0;
		
		
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}


	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public String toString() {
		return Name + " works in the " + Department + " Department and is " + age + " years old. "; 
		
	}

	

	


	

}

