package manager.data;

import java.util.ArrayList;

import controllers.MainController;
import database.DataFromDatabase;
import manager.loading.LoadManager;

public class DataManager extends LoadManager {

	/*UNLOADED DATA*/
	public ArrayList<String> getUnloadedFirstNames() {
		return getFirstNamesFromDatabase();
	}
	
	public ArrayList<String> getUnloadedLastNames() {
		return getLastNamesFromDatabase();
	}
	
	public ArrayList<String> getUnloadedBirthdays() {
		return getBirthdaysFromDatabase();
	}
	
	public ArrayList<String> getUnloadedEmails() {
		return getEmailsFromDatabase();
	}
	
	public ArrayList<String> getUnloadedTelNrs() {
		return getTelNrsFromDatabase();
	}
	
	public ArrayList<String> getUnloadedDegrees() {
		return getDegreesFromDatabase();
	}
	
	public ArrayList<String> getUnloadedMeetingDays() {
		return getMeetingDaysFromDatabase();
	}
	
	public ArrayList<String> getUnloadedGenders() {
		return getGendersFromDatabase();
	}
	
	
	/*LOADED DATA*/
	public ArrayList<String> getReloadedFirstNames() {
		loadFirstNames();
		return getFirstNamesFromDatabase();
	}
	
	public ArrayList<String> getReloadedLastNames() {
		loadLastNames();
		return dataFromDatabase.getLastNamesFromDatabase();
	}
	
	public ArrayList<String> getReloadedBirthdays() {
		loadBirthdays();
		return dataFromDatabase.getBirthdaysFromDatabase();
	}
	
	public ArrayList<String> getReloadeddEmails() {
		loadEmails();
		return dataFromDatabase.getEmailsFromDatabase();
	}
	
	public ArrayList<String> getReloadedTelNrs() {
		loadTelNrs();
		return dataFromDatabase.getTelNrFromDatabase();
	}
	
	public ArrayList<String> getReloadedDegrees() {
		loadDegrees();
		return dataFromDatabase.getDegreesFromDatabase();
	}
	
	public ArrayList<String> getReloadedMeetingDays() {
		loadMeetingDays();
		return dataFromDatabase.getMeetingDaysFromDatabase();
	}
	
	public ArrayList<String> getReloadedGenders() {
		loadGenders();
		return dataFromDatabase.getGendersFromDatabase();
	}
	
}
