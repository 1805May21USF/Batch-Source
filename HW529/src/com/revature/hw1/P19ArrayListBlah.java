package com.revature.hw1;

import java.util.ArrayList;

public class P19ArrayListBlah {
	public static void hooplah() {
		int evenAddUp=0;
		int oddAddUp = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int i = 0;
		while (i<10) {
			arr.add(i);
			i++;
		}
		System.out.println(java.util.Arrays.toString(arr.toArray()));
		for (int j = 0; j<arr.size(); j++) {
			if (j%2==0) {
				evenAddUp+=arr.get(j);
			}
			else if(j%2 == 1) {
				oddAddUp+=arr.get(j);
			}
		}
		System.out.println("Even Sum: "+evenAddUp+ " Odd Sum: "+ oddAddUp);
		P9Primes.isItPrime();
		//arr.remove(1);
		//System.out.println(java.util.Arrays.toString(P9Primes.primes.toArray()));
		for (int k=0; k <arr.size(); k++) {
			//System.out.println(arr.get(k));
			if (P9Primes.primes.contains(arr.get(k))) {
				arr.set(k, -1);
			}
		}
		boolean ugh = true;
		while(ugh) {
			for(int q = 0; q < arr.size(); q++) {
				if (arr.get(q) == -1) {		
					arr.remove(q);
					break;
				//TimeUnit.SECONDS.sleep(1);
				}
			}
			if(!arr.contains(-1)) {
				ugh = false;
			}
		}
		System.out.println(java.util.Arrays.toString(arr.toArray()));
	}
}
