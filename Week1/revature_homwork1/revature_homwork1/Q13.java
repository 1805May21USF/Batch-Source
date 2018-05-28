package revature_homwork1;

public class Q13 {
	public static String doit() {
		StringBuilder s = new StringBuilder();
		int nl= 0;
		int nc = 0;
		for(int i = 0;i<10; i++) {
			s.append(i%2 + " ");
			if (nc < nl){nc++;continue; }
			s.append("\n");
			nc= 0;
			nl++;
		}
		return s.toString();
	}
}
