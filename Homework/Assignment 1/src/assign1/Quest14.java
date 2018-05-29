package assign1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Quest14 {
	static {
		// Print to console
		System.out.println("\nQuest14" );
	}
	
	// Use a switch and cases
	public static void SwitchCases(int x) {
		
		switch(x) {
		case 1:
			// If x == 1, print out square root of 9
			System.out.println(String.format("Square Root of 9 is: %.2f", Math.sqrt(9)));
			break;
		case 2:
			// Get current date
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDateTime currDate = LocalDateTime.now();
			System.out.println(dateFormat.format(currDate));
			break;
		case 3:
			// Store String into String Array and print
			String sentence = "I am learning Core Java";
			String[] sentArray = new String[sentence.length()];
			
			for(int i = 0; i < sentence.length(); i++) {
				sentArray[i] = String.valueOf(sentence.charAt(i));
			}
			
			for(int i = 0; i < sentArray.length; i++) {
				System.out.print(sentArray[i]);
			}
		}
		System.out.println();
	}
}
