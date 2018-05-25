package com.revature.test;

public class ThreadTest1 implements Runnable {
	@Override
	public void run() {
		System.out.println("Inside : " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		ThreadTest runner = new ThreadTest();
		
		Thread t = new Thread(runner);
		
		System.out.println("Starting Thread...");
		t.start();
	}
}
