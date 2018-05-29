package com.revature.solutions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
public class FileIO {
	private static final String inFile = "Data.txt";
	public static String formatInput(String str) {
		String[] temp2 = str.split("[:\n]");
		str = "";
		for(int i = 0;i<4;i++) {
			str = str + "Name: " + temp2[0 +(i*4)] + " " + temp2[1 + (i*4)] + "\n";
			str = str + "Age: " + temp2[2 + (i*4)] + " years\n";
			str = str + "State: " + temp2[3+(i*4)] + "\n\n";
		}
		return str;
	}
	public static String readInput() {
		File file =new File(inFile);
		InputStream is= null;
		StringBuilder s= new StringBuilder();
		try {
			is= new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int b=0;
		try {
			while((b=is.read())!=-1) {
				char c = (char) b;
				s.append(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( is!=null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s.toString();
	}
}
