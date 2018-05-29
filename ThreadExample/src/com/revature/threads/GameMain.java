package com.revature.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GameMain {
	public static void main(String[] args) {
		BlockingQueue<Game> queue = new ArrayBlockingQueue<Game>(10);
		GameProducer producer = new GameProducer(queue, 100);
		GameConsumer consumer = new GameConsumer(queue, "Consumer 1");
		GameConsumer consumer2 = new GameConsumer(queue, "Consumer 2");
		GameConsumer consumer3 = new GameConsumer(queue, "Consumer 3");
		GameConsumer consumer4 = new GameConsumer(queue, "Consumer 4");
		GameConsumer consumer5 = new GameConsumer(queue, "Consumer 5");
		
		new Thread(producer).start();
		Thread t = new Thread(consumer);
		t.setPriority(10);
		t.start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
		new Thread(consumer4).start();
		new Thread(consumer5).start();
		
		System.out.println("Producer and consumers have been started...");
	}
}
