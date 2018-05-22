package com.revature.beans;

public class Person {
<<<<<<< HEAD
	
	private static String homePlanet;
=======
	//encapsulation
	private static String homePlanet="earth"; 
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
	private String name;
	private int age;
	private int weight;
	
<<<<<<< HEAD
	
	//Constructors
	public Person() {
		
	}
	
	public Person(String name) {
		this(name,20);
	}
	
	public Person(String name,int age) {
		this(name,age,200);
	}
	

=======
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

	
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
	public Person(String name, int age, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
<<<<<<< HEAD
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	public String getName() {
		return name;
	}
=======
	public String getName() {
		return name;
	}
	

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
=======
	public static String getHomePlanet() {
		return homePlanet;
	}
	
	
	
	
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
	
}
