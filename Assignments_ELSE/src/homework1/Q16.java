package homework1;

public class Q16 {

	public static void main(String[] args) {
		
		//Write a program to display the number of characters for a string input. 
		//The string should be entered as a command line argument using (String [ ] args).
	      System.out.print("Please enter a string: ");
	      String stringInput = System.console().readLine();
	      int stringLength = stringInput.length();
	      if (stringLength > 10) {
	         System.out.println("Input string should not exceed 10 characters");
	      } else {
	         System.out.println("The input string is valid.");
	      }
	   }
	}