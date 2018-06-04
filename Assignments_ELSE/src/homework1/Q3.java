package homework1;

public class Q3 {
	//Reverse a string without using a temporary variable. Do NOT use reverse() in the
	//StringBuffer or the StringBuilder APIs.
	
	//String  reverseS = "abcdefghijklmnopqrstuvwxyz";
	//Use made a for loop that return the length of the string and make sure it give me the last value
	// of the string and return it  as the first value, also checked to see if i is least than zero
	// 
	public static void main(String[] args) {
        String reverseS="abcdefghijklmnopqrstuvwxyz";
        for(int i=reverseS.length()-1;i>=0;i--){
        	reverseS+=reverseS.charAt(i);
        }
        reverseS=reverseS.substring(reverseS.length()/2, reverseS.length());
        System.out.println(reverseS);
    }

}