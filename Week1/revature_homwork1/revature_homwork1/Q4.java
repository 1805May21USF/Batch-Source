package revature_homwork1;

public class Q4 {
	public static int fac(int i) {
		int res = 1;
		while(i>1){
			res*=i;
			i--;
		}
		return res;
	}
}
