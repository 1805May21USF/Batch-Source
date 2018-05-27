package com.revature.corejava;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Q20 
{
	private static String inFile ="Data.txt";
	private Object[] inputFromFile;
	
	//Opens the file. Reads in the contents of each line and stores it into a Object[]. Closes the file
	public Q20()
	{
		try { 
		Stream<String> stream = Files.lines(Paths.get(inFile));
		
			this.inputFromFile = stream.toArray();
			stream.close();
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//Goes through each item in Object[], which is each line from the file. Calls Method formatOutput to print in requested format
	public void formatedDisplayOfItemsFromFile()
	{
		for(Object objTemp : this.inputFromFile)
		{
			System.out.println(formatOutput(objTemp));
		}
	}
	
	//Cast the Object as a String and the splits based on delimiter ":" and stores it to a String[]. Returns a concatenated string formated per instructions.
	private String formatOutput(Object obj)
	{
		String[] temp = ((String)obj).split(":");
		return ("Name: "+temp[0]+" "+temp[1]+"\nAge: "+temp[2]+" years"+"\nState: "+temp[3]+" State");
		
	}
	
}
