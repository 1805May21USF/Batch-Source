package com.revature.hw1;

public class P20PersonObject {
	private int age;
	private String name;
	private String state;
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	/*public P20PersonObject() {
		super();
		// TODO Auto-generated constructor stub
	}*/
	public P20PersonObject(String name, int age, String state) {
		super();
		this.age = age;
		this.name = name;
		this.state = state;
	}
	
	
	
}
