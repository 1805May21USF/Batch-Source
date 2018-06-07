package com.revature.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class Driver {

	public static void main(String[] args) {
		BlockingQueue<Bagel> queue = new ArrayBlockingQueue<Bagel>(10);
		Baker baker = new Baker(queue);
		Customer customer1 = new Customer(queue, "Customer 1");
		Customer customer2 = new Customer(queue, "Customer 2");
		
		new Thread(baker).start();
		Thread t = new Thread(customer1);
		t.setPriority(10);
		t.start();
		new Thread(customer2).start();
		
		System.out.println("Time to Bake some bagels....");

	}

}


