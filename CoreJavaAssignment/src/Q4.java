import java.util.Scanner;

public class Q4 {
	/*
	 * Factorial is the product of an integer and all integers below it to 0. A
	 * for-loop is used to multiply the initial value of 1 to the it's next index up
	 * to the desired N-th index. For example, the factorial of the 4th index will
	 * equal 24.
	 */
	public static void main(String[] args) {
		System.out.println("Q4. Write a program to compute N factorial. Please enter an N value.");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println("The factorial of " + n + " is " + factorial(n) + ".");
		input.close();
	}

	static long factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++)
			result *= i;
		return result;
	}

}
