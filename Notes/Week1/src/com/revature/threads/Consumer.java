package com.revature.threads;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<Message> queue;
	
	private String name;
	
	public Consumer(BlockingQueue<Message> q, String name){	
		this.queue = q;		
		this.name = name;	
	}

	@Override
	public void run() {
		Message msg = null;
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			while(true) {
				msg = queue.poll();

				System.out.println("Consumed cookie " + msg.getMsg() + " by " + name);
			}
		} catch (NullPointerException e1) {
			System.out.println("Ran out of cookies :(.");
		}
		
//		try {
//			queue.put(msg);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
	}

}
