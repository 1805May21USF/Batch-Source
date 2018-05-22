package com.revature.beans;

public class Game {
	//static code block runs once when the class is loaded
	static {
		System.out.println("I am a static code block");
	}
	//code block that runs before the constructor. Cannot call this since the objected has not yet been instantiated
	{
		System.out.println("Inside the code block");
	}
	private String name;
	private String genre;
	private double price;
	
	//overloading constructors
	public Game() {
		this.setName("Tetris");	
		this.setGenre("Crap");
		this.setPrice(1.58);
		System.out.println("A crap game has been created");
	}

	public Game(String name) {
		this(name, "Witcher 3");	
	}
	public Game(String name, String genre) {
		this(name, genre, 75.00);
	}
	public Game(String name, String genre, double price) {
		this.setName(name);
		this.setGenre(genre);
		this.setPrice(price);
		Person p = new Person("Tim");
		System.out.println("I created a person named: " + p.getName());
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
