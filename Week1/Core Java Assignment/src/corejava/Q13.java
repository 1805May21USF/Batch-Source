package corejava;

public class Q13 {
	public static void Solution(int lines) {
		int lineLen = 1;
		boolean zero = true;
		
		//runs until it hits the right number of lines, increasing length of each by 1
		for (int i = 1; i <= lines; i++) {
			for (int j = 0; j < lineLen; j++) {
				if (zero) {System.out.print(0); }
				else { System.out.print(1); }
				zero = !zero;
			}
			lineLen++;
			System.out.println("");
		}
	}
}
