package assign1;



public class Quest3 {
	
	
	
	// Static code block is called once.
	static {
		System.out.println("\nQuest3:" );
	}
	
	public static void ReverseString(String stringToReverse) {
		
		//Alternative: use Scanner to get word.
		//System.out.println("Enter a word to reverse: ");
		//Scanner scan = new Scanner(System.in);
		//stringToReverse = scan.next().toString();
		//scan.close();
		
		System.out.println("Word to reverse: " + stringToReverse);
		
		System.out.print("Reversed word: ");
		
		for(int i = stringToReverse.length() - 1; i >= 0; i--) {
			System.out.print(stringToReverse.charAt(i));
		}
		
		
		
	}
}
