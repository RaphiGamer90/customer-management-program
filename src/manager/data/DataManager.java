package manager.data;

import java.util.ArrayList;

import database.ValuesFromDatabase;
import manager.loading.MainLoadingManager;
import manager.loading.dataFromDatabase.LoadTelNrs;

public class DataManager {
	
	MainLoadingManager loadingManager = new MainLoadingManager();
	ValuesFromDatabase valuesFromDatabase = new ValuesFromDatabase();

	public ArrayList<String> getFirstNames() {
		loadingManager.loadFirstNames(valuesFromDatabase);
		return valuesFromDatabase.getFirstNamesFromDatabase();
	}
	
	public ArrayList<String> getLastNames() {
		loadingManager.loadLastNames(valuesFromDatabase);
		return valuesFromDatabase.getLastNamesFromDatabase();
	}
	
	public ArrayList<String> getBirthdays() {
		loadingManager.loadBirthdays(valuesFromDatabase);
		System.out.println(valuesFromDatabase.getBirthdaysFromDatabase());
		return valuesFromDatabase.getBirthdaysFromDatabase();
	}
	
	public ArrayList<String> getEmails() {
		loadingManager.loadEmails(valuesFromDatabase);
		return valuesFromDatabase.getEmailsFromDatabase();
	}
	
	public ArrayList<String> getTelNrs() {
		loadingManager.loadTelNrs(valuesFromDatabase);
		return valuesFromDatabase.getTelNrFromDatabase();
	}
	
	public ArrayList<String> getDegrees() {
		loadingManager.loadDegrees(valuesFromDatabase);
		return valuesFromDatabase.getDegreesFromDatabase();
	}
	
	public ArrayList<String> getMeetingDays() {
		loadingManager.loadMeetingDays(valuesFromDatabase);
		return valuesFromDatabase.getMeetingDaysFromDatabase();
	}
	
	public ArrayList<String> getGenders() {
		loadingManager.loadGenders(valuesFromDatabase);
		return valuesFromDatabase.getGendersFromDatabase();
	}
}
