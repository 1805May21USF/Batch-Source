package com.revature.same;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {

	public ReadFromFile() {
		// TODO Auto-generated constructor stub
		Scanner sc;
		String words = null;
		String words2 = null;
		Person p = new Person();
		try {
			File file = new File("src/com/revature/same/Data.txt");
			sc = new Scanner(file);
			for(int i = 0; i < 4; i++) {
				words = sc.next();
				String[] line = words.split(":");
				
				p.setName(line[0]);
				p.setAge(line[1]);
				p.setState(line[2]);
					
				System.out.println(p.toString());
				if(i < 3)
					System.out.println();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
