package javaCore;

import java.io.*;

public class q20Read {
		//count line numbers
	{
		int lineNumber = 0;
	
		try {
			BufferedReader in = new BufferedReader(new FileReader("Data.txt"));
			
			String line = null;
			
			while ((line = in.readLine()) != null) {
				lineNumber ++;
				System.out.println("Line " + lineNumber + " : " + line);
		}
			in.close();

} 
		catch (IOException e) {
	e.printStackTrace();
}

}

}