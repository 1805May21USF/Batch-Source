package javaCore;

public class q15implementsInterface implements q15Interface {
	
	
		
	public static void addition(int myNum, int myNumToo) {
		int a = myNum + myNumToo;
		System.out.println(a);
	}
	public static void subtraction(int myNum, int myNumToo) {
		int b = myNum - myNumToo;
		System.out.println(b);
	}
	public static void multiplication(int myNum, int myNumToo) {
		int c = myNum * myNumToo;
		System.out.println(c);
}
	public static void division(int myNum, int myNumToo) {
		int d = myNum / myNumToo;
		System.out.println(d);
}
}
