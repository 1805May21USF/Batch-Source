package com.revature.beans;

public class Game {
	
	//Static code block
	static {
		System.out.println("This is the static code block....");
		/* 
		 * Static code block executes only once when the class is loaded.
		 * */
	}
	
	//Code block
	{
		/*
		 * Instance code block that executes before constructor when object is instantiated.
		 * NOTE: You CANNOT reference the object using the "this" keyword, since the object isn't instantiated yet.
		 */
		System.out.println("Inside the code block");
	}
	//Static code block
	static {
		//Static code blocks are similar.
		//These execute once, when the class is loaded.
		System.out.println("I'm a static code block");
	}
	//code block
	{
		//instance code block that executes before constructor
		//when object is instantiated. Note that we can't reference 
		//the object using "this," since the object isn't instantiated 
		//yet.
		System.out.println("Inside code block");
	}
	private String name;
	private String genre;
	private double price;
	
	//overloading constructors
	public Game() {
		this.setName("Tetris");
		this.setGenre("Good");
		this.setPrice(1.50);
		System.out.println("This is tetris.");

	}
	
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person s = new Person("Jim");
		System.out.println(s.getName() + " is playing a game");
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
