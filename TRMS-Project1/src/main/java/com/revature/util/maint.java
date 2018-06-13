package com.revature.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class maint {
	public static void main(String[] args) throws IOException {
		java.io.File file = new java.io.File("database.properties");
		System.out.println("Does it exist? " + file.getCanonicalPath());

//		try {
//			FileReader fr = new FileReader(file);
//			System.out.println("!!!! !!" + fr.toString() + "   ");
//			char[] a = new char[3000];
//			fr.read(a); // reads the content to the array
//
//			for (char c : a)
//				System.out.print(c); // prints the characters one by one
//			fr.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
