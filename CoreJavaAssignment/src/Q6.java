import java.util.Scanner;

public class Q6 {
	/*
	 * Q6. Write a program to determine if an integer is even without using the
	 * modulus operator (%)
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print(
				"Q6. Write a program to determine if an integer is even without using the modulus operator (%). "
						+ "\nPlease enter an integer: ");
		int t = input.nextInt();
		/*
		 * To determine if an integer is odd or even without the use of the modulus
		 * operator (%) is to divide the integer by 2 then multiplying it by 2. If the
		 * number is odd, then the result will not equal the original integer value.
		 */
		System.out.println((t / 2) * 2 == t ? t + " is even" : t + " is odd");
		input.close();
	}
}
