package com.revature.threads;
import java.util.Arrays;


public class myRunnable implements Runnable {

	private String threadName;
	String [] Arr = new String [100];
	String check = "";
	

	public void setArr(String[] arr) {
		Arr = arr;
	}
	
	public String[] getArr() {
		return Arr;
	}
	
	public myRunnable(String threadName, String arr []) {
		this.threadName = threadName;
		this.Arr = arr;
	}

	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String p = "";
		String Piz = "";
		System.out.println("ThreadName " + this.threadName);
		
			for(int i = 0; i < this.getArr().length; i++) {
					Piz = this.Arr[i];
					if(Piz.equals(p));
				}
			
	}


	public String getThreadName() {
		return threadName;
	}


	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

}
