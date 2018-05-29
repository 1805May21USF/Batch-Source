package javaCore;

public class q15Driver {

	public static void main(String[] args) {
		int myNum = 1;
		int myNumToo = 2;
	
		q15implementsInterface imp = new q15implementsInterface();

		imp.addition(myNum, myNumToo);
		imp.subtraction(myNum, myNumToo);
		imp.multiplication(myNum, myNumToo);
		imp.division(myNum, myNumToo);

	}

}
