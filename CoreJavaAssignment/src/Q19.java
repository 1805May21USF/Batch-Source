import java.util.ArrayList;

public class Q19 {
	/*
	 * Q19. Create an ArrayList and insert integers 1 through 10. Display the
	 * ArrayList. Add all the even numbers up and display the result. Add all the
	 * odd numbers up and display the result. Remove the prime numbers from the
	 * ArrayList and print out the remaining ArrayList.
	 */
	public static void main(String[] args) {
		System.out.println("Q19. Create an ArrayList and insert integers 1 through 10."
				+ " Display the ArrayList. Add all the even numbers up and display the "
				+ "result. Add all the odd numbers up and display the result. Remove the"
				+ " prime numbers from the ArrayList and print out the remaining ArrayList.");
		ArrayList<Integer> t = new ArrayList<>();
		// This for-loop adds the values from 1 through 10 into the ArrayList.
		for (int i = 1; i < 11; i++) {
			t.add(i);
		}
		System.out.println("Initial arraylist: " + t);
		int sumEven = 0;
		int sumOdd = 0;
		// This enhanced for-loop checks the integer value if it is odd or even. After
		// the determination, the value is added to determine it's sum from the
		// ArrayList.
		for (int i : t) {
			if (i % 2 == 0) {
				sumEven += i;
			} else {
				sumOdd += i;
			}
		}
		System.out.println("Sum of all even numbers: " + sumEven);
		System.out.println("Sum of all odd numbers: " + sumOdd);
		/*
		 * A checkPrime function was created to check if the integer is a prime number.
		 * If true, then the integer would be removed from the arraylist.
		 */
		for (int i = 0; i < t.size(); i++) {
			if (!checkPrime(i)) {
				t.remove(i);
			}
		}
		System.out.println("Remaining arraylist without prime numbers: " + t);
	}

	/*
	 * This function is used to determine if an integer is a prime number. A prime
	 * number is a number that is only divisible by itself and 1. If a number is
	 * even, then it cannot be a prime number. Therefore we must check odd numbers
	 * to see if it is prime.
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
