package corejava;

import java.util.ArrayList;

public class Q9 {
	//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
		public static void Solution() {
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			boolean isPrime = true;
			
			//loop, add each number and check each for primes, printing them when found
			for (Integer i = 1; i <= 100; i++) {
				numbers.add(i);
				for(Integer j = 2; j < i; j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					System.out.println(i);
				}
				isPrime = true;
			}
		}
}
