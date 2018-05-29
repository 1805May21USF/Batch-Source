package com.revature.threads;

import java.util.concurrent.BlockingQueue;

public class GameConsumer implements Runnable{
	
	private BlockingQueue<Game> queue;
	private String name;
	
	public GameConsumer(BlockingQueue<Game> queue, String name) {
		this.queue = queue;
		this.name = name;
	}
	
	@Override
	public void run() {
		Game game;
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			while (!(game = queue.take()).getName().equals("exit")){
				if(game.getName().equals("need"))
					System.out.println("We need a game!");
				else
					System.out.println("Game " + game.getName() + " was purchased by " + name);
				
			}
			System.out.println("Game is sold out, fans are sad.");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			queue.put(new Game());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
