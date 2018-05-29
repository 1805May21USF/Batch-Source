package com.revature.threads;

public class PizzaFactory implements Runnable {

	private String pizza[] = new String [100];
	private String name;
	
	public PizzaFactory(String nam, String Arr []) {
		this.name = name;
		this.pizza = Arr;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			System.out.println("Pizza factory running!");
				
	}
		
	public String[] getPizza() {
		return pizza;
	}

	public void setPizza(String pizza[]) {
		this.pizza = pizza;
	}
	
}
