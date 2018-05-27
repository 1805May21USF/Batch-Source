package com.revature.same;

public class StringOperations extends StringImpl {

	public StringOperations() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean toupper(String word) {
		for(int i = 0; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i)))
             	return true;
         }
		return false;
	}
	
	public String tolower(String word) {
		char[] array = new char[word.length()];
        for(int i = 0; i < word.length();i ++) {
          if(Character.isLowerCase(word.charAt(i))) {
        	  array[i] = Character.toUpperCase(word.charAt(i));
          }
          else {
              array[i] = word.charAt(i);
           }
        }
          return new String(array);
        
	}
	public int toInt(String number) {
		//Integer.parseInt(c);
        int  d = Integer.parseInt(number);
        //System.out.println(d + 10);
        return d + 10;
	}

}
