package manager.data;

import java.util.ArrayList;

import database.DataFromDatabase;
import manager.loading.LoadingManager;
import manager.loading.dataFromDatabase.LoadTelNrs;

public class DataManager {
	
	LoadingManager loadingManager = new LoadingManager();
	DataFromDatabase dataFromDatabase = new DataFromDatabase();

	/*UNLOADED DATA*/
	public ArrayList<String> getFirstNames() {
		return dataFromDatabase.getFirstNamesFromDatabase();
	}
	
	public ArrayList<String> getLastNames() {
		return dataFromDatabase.getLastNamesFromDatabase();
	}
	
	public ArrayList<String> getBirthdays() {
		return dataFromDatabase.getBirthdaysFromDatabase();
	}
	
	public ArrayList<String> getEmails() {
		return dataFromDatabase.getEmailsFromDatabase();
	}
	
	public ArrayList<String> getTelNrs() {
		return dataFromDatabase.getTelNrFromDatabase();
	}
	
	public ArrayList<String> getDegrees() {
		return dataFromDatabase.getDegreesFromDatabase();
	}
	
	public ArrayList<String> getMeetingDays() {
		return dataFromDatabase.getMeetingDaysFromDatabase();
	}
	
	public ArrayList<String> getGenders() {
		return dataFromDatabase.getGendersFromDatabase();
	}
	
	
	/*LOADED DATA*/
	public ArrayList<String> getLoadedFirstNames() {
		loadingManager.loadFirstNames(dataFromDatabase);
		return dataFromDatabase.getFirstNamesFromDatabase();
	}
	
	public ArrayList<String> getLoadedLastNames() {
		loadingManager.loadLastNames(dataFromDatabase);
		return dataFromDatabase.getLastNamesFromDatabase();
	}
	
	public ArrayList<String> getLoadedBirthdays() {
		loadingManager.loadBirthdays(dataFromDatabase);
		return dataFromDatabase.getBirthdaysFromDatabase();
	}
	
	public ArrayList<String> getLoadedEmails() {
		loadingManager.loadEmails(dataFromDatabase);
		return dataFromDatabase.getEmailsFromDatabase();
	}
	
	public ArrayList<String> getLoadedTelNrs() {
		loadingManager.loadTelNrs(dataFromDatabase);
		return dataFromDatabase.getTelNrFromDatabase();
	}
	
	public ArrayList<String> getLoadedDegrees() {
		loadingManager.loadDegrees(dataFromDatabase);
		return dataFromDatabase.getDegreesFromDatabase();
	}
	
	public ArrayList<String> getLoadedMeetingDays() {
		loadingManager.loadMeetingDays(dataFromDatabase);
		return dataFromDatabase.getMeetingDaysFromDatabase();
	}
	
	public ArrayList<String> getLoadedGenders() {
		loadingManager.loadGenders(dataFromDatabase);
		return dataFromDatabase.getGendersFromDatabase();
	}
}
