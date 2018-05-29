package com.revature.threads;

import java.util.Arrays;

public class Test {

	static String [] pizza = new String[100];
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Thread p = new Thread(new PizzaFactory("PizzaFactory!", pizza));
		p.start();
		Thread p2 = new Thread(new PizzaFactory("PizzaFactory2", pizza));
		p2.start();
		Thread p3 = new Thread(new PizzaFactory("PizzaFactory3", pizza));
		p3.start();
		Thread t1 = new Thread(new myRunnable("Bob", pizza));
		t1.start();
		
	}

}
