import java.util.Scanner;
import com.bank.intro.*;
import com.bank.intro.login.Login;
import com.bank.intro.register.RegisterMain;

public class bankMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/* Create a switch-case statement to iterate on the multiple choices ... */
		while (true) {
			Intro intro = new Intro();
			System.out.print(intro.getWelcome());
			/*
			 * The switch-case after the welcome prompts the user if they would like to
			 * register for an account or to login if they already have an account
			 */
			try {
				switch (input.next()) {
				case "1":
					/*
					 * Case 1: Register and apply for a bank account A RegisterNewAccount object is
					 * created and prints a welcome string. The user is prompted to enter a unique
					 * user name and password
					 */
					new RegisterMain();
					break;
				case "2":
					/*
					 * Case 2: The user is prompted to enter a user name and password. If the user
					 * name and password is found in the Person.txt, then more options will appear
					 * for the user depending on the user status.
					 */
					new Login();
					break;
				case "3":
					System.out.println("Thank you for using Tiffany's Banking App! Have a nice day.");
					input.close();
					System.exit(0);
				default:
					System.out.println("ERROR: You have entered the wrong option. Please try again.");
				}
			} catch (Exception ex) {
				System.out.println("Exception caught in bankMain: " + ex.getMessage());
			}
		}
	}
}
