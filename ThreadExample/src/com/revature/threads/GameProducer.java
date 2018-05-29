package com.revature.threads;

import java.util.concurrent.BlockingQueue;

public class GameProducer implements Runnable {
	
	private BlockingQueue<Game> queue;
	private int number;
	
	public GameProducer(BlockingQueue<Game> queue, int number) {
		this.queue = queue;
		this.number = number;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < number; i++) {
			Game game = new Game();
			Game need = new Game();
			need.setName("need");
			
			System.out.println("New Game Coming!");
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			game.setName("Code Quest " + i);
			
			System.out.println("Game is called " + game.getName());
			
			try {
				queue.put(need);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			game.setGenre("Adventure");
			
			System.out.println(game.getName() + " is an " + game.getGenre() + " game!");
			
			try {
				queue.put(need);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			game.setCost(40);
			
			System.out.println(game.getName() + " will cost $" + game.getCost());
			
			try {
				queue.put(need);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			game.setRating('T');
			
			System.out.println(game.getName() + " will be rated " + game.getRating() + "!");
			
			try {
				queue.put(need);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(game.getName() + " is now out!");
			
			for(int j = 0; j < 5; j++) {
				try {
					queue.put(game);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				queue.put(need);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Game exit = new Game();
				exit.setName("exit");
				queue.put(game);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
