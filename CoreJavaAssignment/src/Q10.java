import java.util.Scanner;

public class Q10 {
	/* Q10. Find the minimum of two numbers using ternary operators. */
	public static void main(String[] args) {
		System.out.println("Q10. Find the minimum of two numbers using ternary operators. Enter two numbers: ");
		Scanner input = new Scanner(System.in);
		double n1 = input.nextDouble();
		double n2 = input.nextDouble();
		/*
		 * Ternary operator is an operator that takes three arguments. The first
		 * argument is a comparison argument, the second is the result if the comparison
		 * is true, and the third is the result if the comparison is false. Ternary
		 * operator also uses the symbols ? and : together.
		 */
		System.out.println(((n1 < n2) ? n1 + " is minimum number" : n2 + " is minimum number"));
		input.close();
	}

}
