package com.revature.questions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.revature.qtwenty.Celebrity;


public class QuestionTwenty {
	
	
	private static final String dataFile = "src/Data.txt";
	static public ArrayList<Celebrity> characterList = new ArrayList<Celebrity>();
	
	public QuestionTwenty() {
		
	}
	
	public void run() {
			readCelebrityFile();
			
			for(Celebrity c: characterList) {
				System.out.println("Name:" + c.getFname() + " " +c.getLname());
				System.out.println("Age" + c.getAge());
				System.out.println("State:" + c.getTown());
				System.out.println();
			}
	}
	
	public void readCelebrityFile() {
			
			try {
				ArrayList<String> lines = new ArrayList<String>();
				lines.addAll(Files.readAllLines(Paths.get(dataFile), StandardCharsets.UTF_8));
				
				for(String line:lines) {
					String[] strs = line.split(":");
					Celebrity c = new Celebrity(strs[0],strs[1],Integer.parseInt(strs[2]),strs[3]);
					characterList.add(c);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

