import java.util.Scanner;

public class Q13 {
	/*
	 * Display the triangle on the console as follows using any type of loop. Do NOT
	 * use a simple group of print statements to accomplish this. Enter the number
	 * of lines that you desire for your triangle.
	 */
	public static void main(String[] args) {
		System.out.println("Q13. Display the triangle on the console as follows using any type of loop. "
				+ "Please enter the number of lines that you desire for your triangle.");
		Scanner input = new Scanner(System.in);
		int q = input.nextInt();
		int t = 0;
		for (int i = 1; i < q; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(t + " ");
				if (t % 2 == 0) {
					t = 1;
				} else {
					t = 0;
				}
			}
			System.out.println();
		}
		input.close();
	}

}
