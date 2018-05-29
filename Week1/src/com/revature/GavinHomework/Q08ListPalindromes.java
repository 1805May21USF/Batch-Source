package com.revature.GavinHomework;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;


//We good
public class Q08ListPalindromes {
	
	Q03Reverse Q3 = new Q03Reverse();
	
	//Testerini fetticini. Why do I doubt you put yourself going through every line
	//of code. If you truly read all of this yourself Matt I pity you. This test is pretty 
	//easy to understand. I use the input you gave me and the output you gave me and put them
	//equal to each other.
	@Test
	public void tester() {
		ArrayList<String>  a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		a.add("narak");
		a.add("madam");
		a.add("tom");
		a.add("civic");
		a.add("radar");
		a.add("ymmij");
		a.add("kayak");
		a.add("nhoj");
		a.add("refer");
		a.add("yllib");
		a.add("did");
		
		b.add("madam");
		b.add("civic");
		b.add("radar");
		b.add("kayak");
		b.add("refer");
		b.add("did");
		assertArrayEquals(b.toArray(),niceWord(a).toArray());

		
	}

	
	//The logic here is fun because we use the reverse function from
	//question three. No reason to re-invent the wheel. With the reverse
	//function I checked if the word was equal to itself reversed. If it was,
	//I added it to the array list.
	ArrayList<String> niceWord(ArrayList<String> arrList) {
		
		ArrayList<String> arr =  new ArrayList<String>();
		for(int i = 0; i < arrList.size(); i++) {
			if(arrList.get(i).equals(Q3.reverse((arrList.get(i))))) {
				arr.add(arrList.get(i));
			}
		}
		return arr;
	}

	
}
