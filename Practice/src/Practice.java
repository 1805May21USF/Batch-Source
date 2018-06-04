import java.util.Date;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		 String regex = "[0-9]*\\.*[0-9]*";
		 String regex2 = "\\d+";
		
		 // positive test cases, should all be "true"
		 System.out.println("50.0".matches(regex));
		 System.out.println("$500".matches(regex));
		 System.out.println("-123.456789".matches(regex));
		//
		// System.out.println();
		// // negative test cases, should all be "false"
		// System.out.println("111".matches(regex2));
		// System.out.println("foo".matches(regex2));
		// System.out.println("aa123bb".matches(regex2));

//		Date t = new Date();
//		System.out.println(t.getTime());
//		int hex = Integer.parseInt(t.getTime()+"", 16);
//		System.out.println(hex);
//		Scanner input = new Scanner(System.in);
//		LoopB: while (true) {
//			System.out.println("How much would you like to withdraw? ");
//			String amount = input.next();
//			if (checkIfDigit(amount)) {
//				System.out.println("ERRORRRRRR");
//				break;
//			}
//		}
	}
	
	private static boolean checkIfDigit(String t) {
		return t.matches("[0-9]");
	}
}
