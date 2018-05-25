package com.sunny.thread;

public class ThreadMe {
	public static void main(String[] args) {
		ThreadExample te = new ThreadExample();
		Thread t1 = new Thread(te);
		Thread t2 = new Thread(te);
		t1.start();
		t2.start();
	}
}
