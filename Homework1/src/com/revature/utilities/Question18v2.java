package com.revature.utilities;

public class Question18v2 extends Question18 {

	
	public boolean Uppercase (String a) {
		 
		  for(int i = 0; i < a.length(); i++) {
			  if (Character.isUpperCase(a.charAt(i)))
			  {
			  return true; 
		  }
}
			  
		  return false;
		  
	}

	public String Lowercase(String b) {
		
		char[] array=new char[b.length()];
		for(int i = 0; i < b.length();i ++) {
		  if(Character.isLowerCase(b.charAt(i))) {
			 
			  
			  
			  array[i] = Character.toUpperCase(b.charAt(i));
			  
		  }
		  else {
			  array[i] = b.charAt(i);
			  
		  // Character.toUpperCase(b.charAt(i)){
				
		  }
			
		
		//  array[i] = Character.toUpperCase(b.charAt(i));
			
			}
			
		
	
		return new String(array);
	}

	
	public void  Convert(String c) {
		
		//Integer.parseInt(c);
		int  d = Integer.parseInt(c);
		System.out.println(d + 10);
	
	}

	
	
}