package com.revature.hw1;

public class Employee {
	private int age;
	private String name;
	private String dept;
	
	Employee(){
		
	}
	Employee(String n, String d, int a){
		this.name = n;
		this.dept = d;
		this.age = a;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	
	
}
