package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Q18TheFounder extends Q18SuperSizeMe {

	//This method goes through the entire string and instantly says
	//True the moment there is an uppercase letter
	@Override
	public boolean hasUppercase(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) return true;
		}
		return false;
	}

	
	//This method has a temp string, which are for weenies, and 
	//adds to the string every letter. If the letter is undercased it will
	//add the upper cased letter.
	@Override
	public String changeToUppercase(String str) {

		String tempStr = "";
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) tempStr += str.charAt(i);
			else tempStr+= Character.toUpperCase(str.charAt(i));
		}
		return tempStr;
	}

	//This method took some searching but the Integer
	//parse method was exactly what I was looking for.
	@Override
	public int addTen(String str) {

		return (Integer.parseInt(str) + 10);
	}
	
	@Test
	public void tester() {
		
		assertEquals(false,hasUppercase("dance"));
		assertEquals("DANCE",changeToUppercase("danCe"));
		assertEquals(15,addTen("5"));
	}
	
	

}
