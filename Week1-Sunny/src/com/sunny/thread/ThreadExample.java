package com.sunny.thread;

public class ThreadExample implements Runnable {
	private final int finish = 100;
	private int count = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (count != finish) {
			count++;
			System.out.println("Thread " + Thread.currentThread().getId() + 
					" took number " + (getFinish() - count) + " out of 100.");
		}
		
	}


	public int getFinish() {
		return finish;
	}



}
