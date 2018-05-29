package com.revature.threads;

public class ThreadMain {
	public static void main(String[] args) {
		ThreadExample one = new ThreadExample("Axolotl", 50);
		ThreadExample two = new ThreadExample("Chrono Trigger", 25);
		
		new Thread(one).start();
		new Thread(two).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 30; i++) {
			System.out.println("Interruption!");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
