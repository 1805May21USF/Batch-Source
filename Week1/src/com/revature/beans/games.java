package com.revature.beans;

public class games {
	
	//static code block
	static {
		//static code blocks are similar. 
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
	private Double price;
	
	
	//overloading constructors
	public games() {
		this.setName("Tetris");
		this.setGenre("Crap");
		this.setPrice(1.50);
		System.out.println("I created a crap game");
	}
	
	
	public games(String name, String genre, Double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person s = new Person("Jim");
		System.out.println("I created a game and a person named " + s.getName() );
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
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "games [name=" + name + ", genre=" + genre + ", price=" + price + "]";
	}
	
	
	
	
}
