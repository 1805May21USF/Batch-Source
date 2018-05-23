package com.revature.beans;



public class Game {
	//Static code block 
	static {
		System.out.println("I'm a static code block");
}
{
	//code block
	
		// instance code block that executes before constructor
		// when object is instantiated. Note that we can't reference 
		// the object using "this", since the object isn't instantiated 
		// yet. 

		System.out.println("Inside code block");
}

	private String name;
	private String genre;
	private double price;
	
	//overloading constructors
	// default constructors 
	
	public Game() {
		this.setName("Zelda");
		this.setGenre("Good");
		this.setPrice(60);
		System.out.println("I like playing this game");
	}
	
	
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person s= new Person("Nick");
		System.out.println("t" + s.getName());
		
	}


	public String getName() {
		return name;
	}
	//public Game() {
		//super();
		// TODO Auto-generated constructor stub
	//}
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
	

	
	
	
	

}
