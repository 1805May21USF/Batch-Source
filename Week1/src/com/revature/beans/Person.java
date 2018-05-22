package com.revature.beans;

public class Person {
	//encapsulation
<<<<<<< HEAD
	private static String homePlanet = "earth";
=======
	private static String homePlanet="earth"; 
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
	private String name;
	private int age;
	private int weight;
	
	//Constructors
	//Default
<<<<<<< HEAD
	public Person() {
		
	}
	
	public Person(String name) {
		this(name,20); //Constructor chaining
	}
	
	public Person(String name, int age) {
		this(name,age,200);
	}
	
	public Person(String name, int age, int weight) {
=======
	
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
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
<<<<<<< HEAD

=======
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
	public String getName() {
		return name;
	}
	
<<<<<<< HEAD
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}	
	
=======

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
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
	public static String getHomePlanet() {
		return homePlanet;
	}
	
	public int eat() {
<<<<<<< HEAD
		this.setWeight(weight + 5);
		return this.getWeight();
	}
	
=======
		this.setWeight(weight+5);
		return this.getWeight();
	}
	
	
	
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
}
