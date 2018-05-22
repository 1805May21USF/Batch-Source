package com.revature.beans;

public class Person {
<<<<<<< HEAD
	
	//Encapsulation
	private String name;
	private int age;
	private int weight;
	private static String homeplanet = "Earth";
	
	//Constructors
	public Person() {
		super();
		
	}
	public Person(String name) {
		this(name, 20);
	}
	
	public Person(String name, int age) {
		this(name, age, 200);
	}
	
	public Person(String name, int age, int weight) {
=======
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
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
<<<<<<< HEAD

=======
	
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
	public String getName() {
		return name;
	}
	
<<<<<<< HEAD
=======

>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
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
<<<<<<< HEAD
	
	public static String getHomeplanet() {
		return homeplanet;
	}
	public static void setHomeplanet(String homeplanet) {
		Person.homeplanet = homeplanet;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}

=======
	public static String getHomePlanet() {
		return homePlanet;
	}
	
	
	
	
	
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
}
