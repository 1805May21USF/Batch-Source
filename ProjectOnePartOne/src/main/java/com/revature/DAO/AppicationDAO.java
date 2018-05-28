package com.revature.DAO;

import java.util.ArrayList;

import com.revature.beans.Application;

public interface AppicationDAO {
	   public ArrayList<Application> getAllApplication();
	   public Application getApplication(int ID);
	   public void updateApplication(Application application);
	   public void deleteApplication(Application application);
}
