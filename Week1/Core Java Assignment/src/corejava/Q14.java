package corejava;

import java.util.Date;

public class Q14 {
	/*Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
	Case 1: Find the square root of a number using the Math class method.
	Case 2: Display today’s date.
	Case 3: Split the following string and store it in a string array.
	            “I am learning Core Java”
	*/
		public static void Solution() {
			for (int i = 1; i <= 3; i++) {
				switch (i) {
					case 1: 
						System.out.println(Math.sqrt(36));
						break;
					case 2:
						Date date = new Date();
						System.out.println(date.toString());
					case 3:
						String str = "I am learning Core Java";
						String[] strArr = str.split(" ");
						for (String word : strArr) {
							System.out.println(word);
						}
				}
			}
		}
}
