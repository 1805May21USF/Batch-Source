package com.revature.io;

import com.revature.beans.Person;

public class SerializeDemo {
	public static void main(String[] args) {
		IO io= new IO();
		/*
		 * if output.txt (the file that data is being written to)
		 * does not exist, it will create it!
		 * if it does not exist, run it, and then refresh project 
		 * in the project explorer to see it
		 */
		//io.writeOutputStreamContents("Hello");
		
		
		/*
		 * The file that data is being read FROM must exist already.
		 */
		System.out.println(io.readInputStreamContents());
		
		/* Reading and writing Collections
		 * This is using com.revature.beans.Person
		 *  which now implements Serializable.
		 *  We needed to add a serialVersionUID variable also.
		 */
		
		
	/*	Person p = new Person("Matt");
		IOWithCollections.personList.add(p);
		Person s= new Person("Gavin");
		IOWithCollections.personList.add(s);
		
		IOWithCollections.writePersonFile();*/
		
		/*IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.get(0).getName());*/
	}
}
