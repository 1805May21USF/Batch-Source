public class Q12 {
	/*
	 * Q12. Write a program to store numbers from 1 to 100 in an array. Print out
	 * all the even numbers from the array. Use the enhanced FOR loop for printing
	 * out the numbers.
	 */
	public static void main(String[] args) {
		System.out.println("Q12. Write a program to store numbers from 1 to 100 in"
				+ " an array. Print out all the even numbers from the array. Use "
				+ "the enhanced FOR loop for printing out the numbers.");
		int[] num = new int[100];
		// This for loop is used to store numbers from 1 to 100
		for (int i = 1; i < 101; i++) {
			num[i - 1] = i;
		}
		/* The enhanced for loop is also known as the for-each loop.
		 * The for-each loop is written as for (elementType element : arrayRefVar)
		 * The enhanced for loop was used to print all the even numbers from the array. */
		for (int t : num) {
			if (t % 2 == 0) {
				System.out.print(t + " ");
			}
		}

	}

}
