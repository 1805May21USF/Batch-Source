package com.revature.first;

public class Question5 {
	
	public void sub(int start, int end, String phrase) 
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i=start; i<=end; i++) 
		{
			sb.append(phrase.charAt(i)); //appending each character to sb 
		}
		
		System.out.println("The substring of: "+phrase+" that starts from: "+start+" and ends at: "+end+" is: " +sb);
		
	}

}
