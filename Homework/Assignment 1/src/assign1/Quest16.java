// comment out package before compiling Quest16.java and running solo
package assign1;

public class Quest16{
	
	public static void main(String[] args){
		// Count the total characters of args
		// Using command line:
		//		javac Quest16.java
		//		java Quest16 hello there
		// Output: Number of characters for String[] args is: 10
		int totalChars = 0;
		System.out.println("args.length :" + args.length);
		for(int i = 0; i < args.length; i++){
			totalChars += args[i].length();
		}
		System.out.println("Number of characters for String[] args is: " + totalChars);
	}
}