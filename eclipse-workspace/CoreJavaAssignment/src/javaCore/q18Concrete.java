package javaCore;

public class q18Concrete extends q18SuperConcrete {
	static String myString = "This String Has Caps";
	public boolean uppercase(){
		
		char ch;
	    boolean capitalFlag = false;
	    boolean lowerCaseFlag = false;
	    boolean numberFlag = false;
	    for(int i=0;i < myString.length();i++) {
	        ch = myString.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = true;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag)
	            return true;
	    }
	    return false;
	}
	
	public void lowerToUpper(){
		myString = myString.toUpperCase();
		System.out.println(myString);

		
	}
	
	public void toIntegerPlusTen(){
		int myNumString = Integer.parseInt("123");
		myNumString = myNumString + 10;
		System.out.println(myNumString);
	}
}
