package assign1;

public class Quest5 {
	
	// Substring of a word
	static String wordSubstring;
	
	// Static code block gets called once max.
	static {
		// Print to console
		System.out.println("\nQuest5:" );
	}
	
	public static String FindSubstring(String str, int idx) {
			
		// Get substring and save into variable
		wordSubstring = str.substring(0, idx);
		return wordSubstring;
	}
}
