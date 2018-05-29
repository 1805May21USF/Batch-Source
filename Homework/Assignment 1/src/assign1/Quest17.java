package assign1;

import java.util.Scanner;

public class Quest17 {
	static {
		// Print to console
		System.out.println("\nQuest17" );
	}
	
	public static void calculateInterest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Calculate Interest.");
		System.out.println("Enter Principal. Example: For $1000.00, enter 1000.00");
		double principal = scan.nextDouble();
		System.out.println("Enter Rate. Example: For 5% rate, enter 5.0");
		double rate = scan.nextDouble();
		System.out.println("Enter Time in Years. Example: For 2 years, enter 2");
		double time = scan.nextInt();
		scan.close();
		System.out.println("Interest = " + (principal * (rate/100) * time));
		System.out.println();
	}
}
