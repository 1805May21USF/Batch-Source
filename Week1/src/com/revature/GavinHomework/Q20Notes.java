package com.revature.GavinHomework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Q20Notes {

	private static final String inFile="Data.txt";

	
	//OH BOY. THE FINAL BOSS. Was there an easier way than to make
	//string splitters and parser from scratch to do this assignment?
	//There was. I know there was. You all wouldn't do this to me.
	//This starts off by putting the entire file into a stringBuilder.
	public void notes() {
	
		File file =new File(inFile);
		InputStream is= null;
		StringBuilder s= new StringBuilder();
	
		
		//Makes sure the file exists.
		try {
			is= new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("There is no data.txt file. What are you doing. Why delete the file.");
			e.printStackTrace();
		} 
		
		//More temps, even though they are for weenies.
		int b = 0;
		int count = 0;
		
		//This adds the file characters to the string using the logic Matt gave us.
		try {	
			while((b=is.read())!=-1) {
				char c = (char)b;
				s.append(c);
				if(c=='\n') count++;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Aight. So this list both holds separated Heros and then begins to hold the seperated arguments
		//from the heros.
		ArrayList<StringBuilder> str = new ArrayList<StringBuilder>();
		
		//Why is this here? I don't know. If I remove it I break the program so 
		//we just gunna pretend you didn't see it. Pray for me.
		str.add(new StringBuilder());
		
		//More weenie temps.
		int i = 0;
		count = 0;
		
		//This loop separates the objects from one another. Putting them in different parts
		//of the str temp using \n to seperate.
		while(i<s.length()) {
			str.add(new StringBuilder());
			while(s.charAt(i) != '\n') {
				str.get(count).append(s.charAt(i));
				i++;
			}
			str.get(count).append(s.charAt(i));
			count++;
			i++;
		}
		
		//Yet another temp. Call it a new programming language.
		int total = count;
		i = 0;
		int county = 0;
		
		//This seperates the words and numbers into different String Builders in the previously mentioned array list.
		//It uses the : to seperate them.
		while(i<total) {			
			for(int j = 0; j < 4; j++ ) {
				str.add(new StringBuilder());
				count++;
				while((str.get(i).charAt(county) != ':') && ((str.get(i).charAt(county) != '\n'))) {
				    if(str.get(i).charAt(county)=='\n') {
				    	county++;
				    	continue;
				    }
					str.get(count).append(str.get(i).charAt(county));
					county++;
				}
				county++;
			}
			county = 0;
			i++;
		}
		
		//This is the final array list of Hero Classes
		ArrayList<Q20Hero> fin = new ArrayList<Q20Hero>();
		
		//This is a mess. I deserve points taken off. OR you could give me bonus points
		//for my ingenuity of making a little baby parser this quickly.
		
		//For all honestly, it turns every string builder object into a string. Then into an integer for the age
		//Then it's put within the hero constructor.
		for(int j = 0; j < total; j++ ) {
			fin.add(new Q20Hero((str.get(total +1+ j*4)).substring(0),(str.get(total+2+j*4)).substring(0),Integer.parseInt((str.get(total+3+j*4)).substring(0)),(str.get(total+4+j*4)).substring(0,(str.get(total+4+j*4).length()-1))));	
		}
		
		//This prints out the to string.
		for(int j = 0; j < total; j++) {
			System.out.println(fin.get(j).toString());
			System.out.println();
			
		}
		
		
	}
	
}
