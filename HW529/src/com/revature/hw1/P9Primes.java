package com.revature.hw1;

import java.util.ArrayList;

public class P9Primes {
	static ArrayList<Integer> primes;
	public static ArrayList<Integer> isItPrime() {
		ArrayList<Integer> numbas = new ArrayList<Integer>(100);
		for (int i = 1; i <= 100; i++) numbas.add(i);
		ArrayList<Integer> noPartDos = new ArrayList<Integer>();
		primes = new ArrayList<Integer>();
		
		for (Integer j : numbas) {
			for (int i = 2; i < j; i++) {
				if (j % i == 0 ) {
					noPartDos.add(j);
					break;
				}
			}
		}
		for(Integer k : numbas) if (!noPartDos.contains(k)) primes.add(k);
		//for(Integer l : primes) System.out.print(l+" ");
		//System.out.println("");
		return primes;
	}
}
