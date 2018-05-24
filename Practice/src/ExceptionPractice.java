import java.util.Scanner;

public class ExceptionPractice {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.gc();
		try {
			while (true) {
				System.out.print("Enter a character: ");
				String t = input.nextLine();
				VowelChecker(t);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void VowelChecker(String s) throws VowelException {
		switch (s.toLowerCase()) {
		case "a":
		case "e":
		case "i":
		case "o":
		case "u":
			throw new VowelException("Congrats!! This is a vowel!!!");
		default:
			System.out.println(s + " isn't a vowel >:(");
		}

	}

}

class VowelException extends Exception {
	VowelException(String s){  
		  super(s);  
		  
		 }
}
