package revature_homwork1;

import java.util.Scanner;

public class Q17 {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	 	System.out.print("Enter your Principal: ");
	    double Principal = scanner.nextDouble();

	    System.out.print("Enter your Rate: ");

	    double rate = scanner.nextDouble();
	    System.out.print("Enter your Time: ");

	    double time = scanner.nextDouble();
	    System.out.println("Interest: " + Principal*rate*time);

		}

}
