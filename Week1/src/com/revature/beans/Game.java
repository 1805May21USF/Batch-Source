package com.revature.beans;

public class Game {
	//Static Code Block
	static {
		//Execute once when class is called
		System.out.println("im only runnin once boi");
	}
	//code block
	{
		//Runs before constructor
		System.out.println("Inside code block");
	}
	private String name;
	private String genre;
	private double price;
	
	//overloading constructor
	public Game() {
		this.setName("Tetris");
		this.setGenre("Beautiful");
		this.setPrice(1.58);
		System.out.println("I created a great game");
		
		
	}
	
	
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person s = new Person("Jim");
		System.out.println("I created a person named " + this.getName());
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
