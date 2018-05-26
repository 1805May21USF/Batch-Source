package com.revature.toomuchhw;

import java.util.ArrayList;

/*Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. 
Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.*/
public class Problem19 {
	ArrayList<Integer> arr;
	
	
	public Problem19(ArrayList<Integer> arr) {
		super();
		this.arr = arr;
	}

	public boolean checkPrime(int p) {
		if(p==1||p==2||p==3) {
			return true;
		}
		for(int i = 2; i <= p/2; i++) {
			if((p%i)==0) {
				return false;
			}
		}
		return true;
	}
	
	public void displayStuff() {
		
		int even=0;
		int odd=0;
		
		//Displays ArrayList
		System.out.println(arr+" ");
		
		//Displays sum of evens
		for(int i:arr) {
			if(i%2 == 0) {
				even+=i;
			}
		}
		System.out.println(even);
		//Displays sum of odds
		for(int i:arr) {
			if(i%2 == 1) {
				odd+=i;
			}
		}
		System.out.println(odd);
		
		//Displays remaining ArrayList
		ArrayList<Integer> nonPrimes = new ArrayList<Integer>();
		for(int j: arr){
			if(!checkPrime(j)) {
				nonPrimes.add(j);
			}
		}
		System.out.println(nonPrimes);
	}

}
