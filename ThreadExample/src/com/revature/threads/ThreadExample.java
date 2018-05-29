package com.revature.threads;

public class ThreadExample implements Runnable {
	private String message;
	private int number;
	
	public ThreadExample(String message, int number) {
		this.message = message;
		this.number = number;
	}
	
	@Override
	public void run() {
		while(number > 0) {
			System.out.println(message);
			number--;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
