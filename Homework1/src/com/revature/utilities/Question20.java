package com.revature.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Question20  {
public static void readfile()  {
	FileReader fr;
	BufferedReader br;
	String[] arr  = new String[4];
	try {
		
	fr = new FileReader("src/Data.txt");
	br = new BufferedReader(fr);
	String s;
	while ((s = br.readLine())!= null) {
		arr[0] = new String();
		arr[1] = new String();
		arr[2] = new String();
		arr[3] = new String();
		System.out.println(s);
	}
	fr.close();
	}catch (Exception e) {
		
		e.printStackTrace();
	}
}   
}
	
	




