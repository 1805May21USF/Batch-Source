package revature_homwork1;

public class Q12 {
	public static StringBuilder doit() {
		int[] data = new int[100];
		int i = 0;
		for (int n = 0; n<data.length; n++) {
			data[n] = i;
			i++;
		}
		StringBuilder s = new StringBuilder();
		for (int n : data) {
			if (n%2==0) {
				s.append(n + ", ");
			}
		}
		return s;
	}
}
