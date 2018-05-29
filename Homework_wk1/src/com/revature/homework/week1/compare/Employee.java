package com.revature.homework.week1.compare;

public class Employee {
	//employee class 
	
	private int age;
	
	private String name;
	
	private String dept;

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

	public Employee(String name, int age, String dept) {
		super();
		this.age = age;
		this.name = name;
		this.dept = dept;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [ name=" + name + ", age =" + age + ", dept=" + dept + "]";
	}
	

}
