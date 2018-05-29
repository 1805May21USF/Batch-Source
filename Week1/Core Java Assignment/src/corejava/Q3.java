package corejava;

public class Q3 {
	public static String Solution(String jumbled) {
		char[] reversed = new char[jumbled.length()];
		//String revJumbled = ".";
		for(int i = jumbled.length(); i >= 1; i--) {
			reversed[reversed.length - i] = jumbled.charAt(i - 1);
			//revJumbled.concat(Character.toString(jumbled.charAt(i - 1)));
		}
		return new String(reversed);
	}
}
