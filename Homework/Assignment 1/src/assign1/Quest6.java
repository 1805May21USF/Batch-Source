package assign1;

public class Quest6 {

	// Static code block gets called once max.
	static {
		// Print to console
		System.out.println("\nQuest6:" );
	}
	
	public static void CheckIfEven(int num) {
		
		System.out.println("Number = " + num);
		
		// Cast num to Integer to access object toString() method.
		Integer numz = (Integer) num;
		// Convert to a String
		String numzStr = numz.toString();
		
		//Find the last element using charAt, conver to String, parse to Integer
		Integer numzAtChar = Integer.parseInt(String.valueOf(numzStr.charAt(numzStr.length() - 1)));
		
		//System.out.println(numzAtChar);
		
		// Check if the last number ends with a 0, 2, 4, 6, or 8. 0 is an even number. Parity of zero.
		if(numzAtChar == 0 || numzAtChar == 2 || numzAtChar == 4 || numzAtChar == 6 || numzAtChar == 8) {
			System.out.println("The number is even.");
		}
		else {
			System.out.println("The number is not even.");
		}
		
		
	}
}
