public class Q2 {
	/*
	 * Q2 will print the first 25 Fibonacci numbers starting at 0 into the console.
	 * Fibonacci series begins with 0 and 1. The next value is found by adding the
	 * two previously known values together. This can easily be done by recursively
	 * calling the method onto itself.
	 */
	public static void main(String[] args) {
		System.out.println("Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.");
		System.out.println("Result: ");
		for (long i = 0; i < 26; i++) {
			System.out.println("Index " + i + ": " + fib(i));
		}
	}

	static int fib(long index) {
		if (index == 0) // Base case
			return 0;
		else if (index == 1) // Base case
			return 1;
		else // Recursive calls
			return fib(index - 1) + fib(index - 2);
	}
}
