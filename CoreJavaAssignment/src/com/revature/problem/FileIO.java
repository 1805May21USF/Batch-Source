package com.revature.problem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	public static void fileIO() {	
		File file = new File("Data.txt");
		String st;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while ((st = br.readLine()) != null) {
				String[] strs = st.split(":");
				System.out.println("Name: " + strs[0] + " " + strs[1]);
				System.out.println("Age: " + strs[2] + " years");
				System.out.println("State: " + strs[3] + " State");
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
