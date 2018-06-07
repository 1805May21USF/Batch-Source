package com.revature.beans;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//encapsulation
	private static String homePlanet="earth"; 
	private String name;
	private int age;
	private int weight;
	
	//Constructors
	//Default
	
	public Person(String name) {
	this(name, 20);	
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person( String name , int age) {
		this(name,age,200);
	}

	
	public Person(String name, int age, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public static String getHomePlanet() {
		return homePlanet;
	}
	
	
	
	
	
}
