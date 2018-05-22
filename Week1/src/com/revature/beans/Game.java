package com.revature.beans;

public class Game {
	//Static code block
	static {
<<<<<<< HEAD
		//static code blocks are similar.
		//These execute once, when the class is loaded.
		System.out.println("I'm Static Shock!");
	}
	//Code block
	{
		//instance code block that executes before constructor
		//when object is instantiated. Note that we can't reference
		//the object using "this" since the object isn't instantiated
		//yet
=======
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
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
		System.out.println("Inside code block");
	}
	private String name;
	private String genre;
	private double price;
	
<<<<<<< HEAD
=======
	//overloading constructors
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
	public Game() {
		this.setName("Tetris");
		this.setGenre("Crap");
		this.setPrice(1.58);
		System.out.println("I created a crap game");
<<<<<<< HEAD
		// TODO Auto-generated constructor stub
	}
	
=======
	}
	
	
	
	
	
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
<<<<<<< HEAD
		Person s = new Person("Jim");
		System.out.println("I created a game and a person named "+s.getName());
	}

	//Overloading constructors
	public String getName() {
		return name;
	}
=======
		Person s= new Person("Jim");
		System.out.println("I created a game and a person named "+
		s.getName());
	}





	public String getName() {
		return name;
	}
	
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
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
<<<<<<< HEAD
	
=======
	@Override
	public String toString() {
		return "Game [name=" + name + ", genre=" + genre + ", price=" + price + "]";
	}
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
	
}
