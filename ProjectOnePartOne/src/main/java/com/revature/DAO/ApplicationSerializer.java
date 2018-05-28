package com.revature.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Application;

public class ApplicationSerializer implements AppicationDAO{
	

	private ArrayList<Application> applications;
	
	public ApplicationSerializer() {
		this.applications = new ArrayList<Application>();
	}
	
	@Override
	public ArrayList<Application> getAllApplication() {
		loadFromFile();
		return this.applications;
	}

	@Override
	public Application getApplication(int ID) {
		loadFromFile();
		for(Application application: this.applications) {
			if(ID == application.getID()) {
				return application;
			}
		}
		return null;
	}

	@Override
	public void updateApplication(Application application) {
		loadFromFile();
		if(getApplication(application.getID())!=null) {
			deleteApplication(application);
		}
		this.applications.add(application);
		saveToFile();
	}

	@Override
	public void deleteApplication(Application application) {
		loadFromFile();
		this.applications.remove(application);
		saveToFile();
		
	}
	
	public void loadFromFile() {
		try {
			
			ObjectInputStream objectInputStream =
				    new ObjectInputStream(new FileInputStream("ApplicationsTable.txt"));
			
			this.applications = (ArrayList<Application>) objectInputStream.readObject();
			for(Application i:this.applications) {
				System.out.println(i);
			}

			objectInputStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Could not read from file!");
		} catch (ClassNotFoundException e) {
			System.out.println("The data in the file was not the class provided!");
		} 
			catch (NullPointerException e) {
			System.out.println("There was no data!");
		}
	}
	
	public void saveToFile() {
		try {
			ObjectOutputStream objectOutputStream =
			        new ObjectOutputStream(new FileOutputStream("ApplicationsTable.txt"));
			
			objectOutputStream.writeObject(applications);
	        objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Couldn't write to file!");
		}
	}

}
