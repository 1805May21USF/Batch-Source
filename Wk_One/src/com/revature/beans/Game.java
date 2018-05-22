package com.revature.beans;

public class Game {
	//static code block
	static {
		//static code blocks are similar
		//These execute once, when the class is loaded
		System.out.println("I am a static code block");
	}

	//code block
	{
		//instance code block that executes before constructor
		//when object is instantiated. Note that we can't reference
		//the object using "this, " since the object isn't instantiated
		//yet
		System.out.println("Inside code block");
	}
	private String name;
	private String genre;
	private double price;
	
	//overloading constructor
	public Game() {
		this.setName("Tetris");
		this.setGenre("Crap");
		this.setPrice(1.99);
		System.out.println("I created a crap game named " + this.getName() 
		+ " and it costs $" + this.getPrice() + ".");
	}
	
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person pg1 = new Person("Jim");
		System.out.println("My name is " + pg1.getName() + " and I created a game called " 
				+ this.getName() + ". It costs only $" + this.getPrice() + ".");
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Game [name=" + name + ", genre=" + genre + ", price=" + price + "]";
	}
	

}
