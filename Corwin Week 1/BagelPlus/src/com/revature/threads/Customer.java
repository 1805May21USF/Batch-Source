

	
	package com.revature.threads;

	import java.util.concurrent.BlockingQueue;

	public class Customer implements Runnable{
		
		private BlockingQueue<Bagel> queue;
		
		private String name;
		
		public Customer (BlockingQueue<Bagel> q, String name){
			
			this.queue = q;
			
			this.name = name;
			
		}

		@Override
		public void run() {

			Bagel bagelType = null;
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while (!(bagelType = queue.take()).getBagelType().equals("closed")){

					System.out.println(" I have eaten  " + bagelType.getBagelType() + " by " + name);
					
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			
			
		}

	}

