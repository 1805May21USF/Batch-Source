package corejava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
	public static void Solution() {
	// path and name
    String fileName = "src/corejava/data.txt";

    // used to go line by line
    String line = null;

    try {
        FileReader fileReader = 
            new FileReader(fileName);

        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);

        String[] strArr = new String[4];
        
        //outputs results for each data block
        while((line = bufferedReader.readLine()) != null) {
        	strArr = line.split(":");
            System.out.println("Name: " + strArr[0] + ' ' + strArr[1]);
            System.out.println("Age: " + strArr[2]);
            System.out.println("State: " + strArr[3] + " State");
            System.out.println();
        }   

        bufferedReader.close();         
    }
    //for if there are problems accessing/reading the file
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName + "'");                
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");         
    }
}
}
