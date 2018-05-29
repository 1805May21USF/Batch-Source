import java.util.ArrayList;

public class Q9 {
	/*
	 * Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all
	 * the prime numbers to the console.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> t = new ArrayList<>();
		// A for-loop is used to store the numbers from 1 to 100 into an integer
		// ArrayList
		for (int i = 1; i < 101; i++) {
			t.add(i);
		}
		// An enhanced for-loop is used to iterate throughout the ArrayList. In the
		// for-loop the checkPrime function is used to check if the integer is a prime
		// number. If it is a prime number then the number will be printed out into the
		// console. 
		for (int i : t) {
			if (checkPrime(i)) {
				System.out.println(i);
			}
		}
	}

	/*
	 * This function is used to determine if an integer is a prime number. A prime
	 * number is a number that is only divisible by itself and 1. If a number is
	 * even, then it cannot be a prime number. Therefore we must check the odd
	 * numbers to see if it is prime.
	 */
	static boolean checkPrime(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
