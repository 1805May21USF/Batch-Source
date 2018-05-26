package revature_homwork1;

public class Q3 {
	public static String rev(String in) {
		StringBuilder s = new StringBuilder();
		for (int i =in.length()-1;i>=0; i--) {
			s.append(in.charAt(i));
		}
		return s.toString();
	}
}
