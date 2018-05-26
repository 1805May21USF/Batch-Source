package revature_homwork1;

public class Q2 {
	public static int[] fib(int max) {
		int[] res = new int[max];
		int fib1=0;
		int fib2=1;
		for(int i=0;i<max;i++) {
			 //System.out.print(fib1+", ");
			res[i]=fib1;
			int temp=fib2;
			 fib2 = fib1+fib2;
			 fib1=temp;
		}
		//System.out.println(":fibs");
		return res;
	}
}
