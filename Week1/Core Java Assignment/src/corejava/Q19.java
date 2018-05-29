package corejava;

import java.util.ArrayList;
import java.util.Arrays;

/*Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * Add all the even numbers up and display the result. Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
*/

public class Q19 {
	
	public static void Solution() {
		//make the initial arraylist
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println(numbers.toString());
		
		int evenTotal = 0;
		int oddTotal = 0;
		
		//adds odd/even numbers to respective variables
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 == 0) { evenTotal += numbers.get(i); }
			else { oddTotal += numbers.get(i); }
		}
		
		System.out.println(evenTotal);
		System.out.println(oddTotal);
		
		//prime check, removes primes from arraylist
		boolean isPrime = true;
		for (int i = 0; i < numbers.size(); i++) {
			for(int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				numbers.remove(numbers.get(i));
			}
			isPrime = true;
		}
		
		System.out.println(numbers);
	}
}
