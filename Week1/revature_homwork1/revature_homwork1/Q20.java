package revature_homwork1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Scanner;

public class Q20 {
	public static void doit() {
		 Scanner in = null;
		 System.out.println("dir is : " +Paths.get("").toAbsolutePath());
		try {
			in = new Scanner(new FileReader("./revature_homwork1/revature_homwork1/HWdata.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
		in.useDelimiter("[:\n]");
		while (in.hasNext()) {
			System.out.println("Name: " + in.next() +" "+in.next());
			System.out.println("Age: " + in.next());
			System.out.println("State: " + in.next() + " State");
			

		}
	}
}
