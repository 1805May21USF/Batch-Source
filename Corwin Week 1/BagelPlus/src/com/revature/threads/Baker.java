package com.revature.threads;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Baker implements Runnable{
	
	private String[] flavors = {"cinammon raisen","plain","everything"};
	private ArrayList<String> flavorsList;
	private BlockingQueue<Bagel> queue;
	
	public Baker(BlockingQueue<Bagel> queue){
		
		this.queue = queue;
		flavorsList = new ArrayList<String>();
		flavorsList.addAll(Arrays.asList(flavors));

	}

	@Override
	public void run() {
		
		for(int i = 0; i < 100; i++){
			
			int b = ThreadLocalRandom.current().nextInt(0,flavors.length);
			Bagel bagelType = new Bagel("" + flavorsList.get(b));
			
			
			try {
				queue.put(bagelType);
				System.out.println("Baked " + bagelType.getBagelType());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		Bagel msg = new Bagel("closed");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
