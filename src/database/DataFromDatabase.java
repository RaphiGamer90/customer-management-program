package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DataFromDatabase {

	ArrayList<String> firstNamesFromDatabase = new ArrayList<>();
	ArrayList<String> lastNamesFromDatabase = new ArrayList<>();
	ArrayList<String> birthdaysFromDatabase = new ArrayList<>();
	ArrayList<String> emailsFromDatabase = new ArrayList<>();
	ArrayList<String> telNrsFromDatabase = new ArrayList<>();
	ArrayList<String> degreesFromDatabase = new ArrayList<>();
	ArrayList<String> meetDaysFromDatabase = new ArrayList<>();
	ArrayList<String> gendersFromDatabase = new ArrayList<>();
	
	
	public void initialiseAllLists() {
		firstNamesFromDatabase();
		lastNamesFromDatabase();
		birthdaysFromDatabase();
		emailsFromDatabase();
		telNrFromDatabase();
		degreesFromDatabase();
		meetingDaysFromDatabase();
		gendersFromDatabase();
	}
	
	/*
	 * Liste aus Vornamen aus der Datenbank
	 * 
	 * */
	public ArrayList<String> firstNamesFromDatabase() {
		String query = "SELECT Vorname FROM customers";		
		firstNamesFromDatabase.clear();

		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				firstNamesFromDatabase.add(result.getString(1));
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return firstNamesFromDatabase;
	}
	
	
	/*
	 * Liste aus Nachnamen aus der Datenbank
	 * 
	 * */
	public ArrayList<String> lastNamesFromDatabase() {
		String query = "SELECT Nachname FROM customers";
		lastNamesFromDatabase.clear();

		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				lastNamesFromDatabase.add(result.getString(1));
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lastNamesFromDatabase;
	}

	
	/*
	 * Liste aus Geburtstagen aus der Datenbank
	 * 
	 * */
	public ArrayList<String> birthdaysFromDatabase() {
		String query = "SELECT Geburtstag FROM customers";
		birthdaysFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			
			while(result.next()) {
				birthdaysFromDatabase.add(result.getString(1));	
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return birthdaysFromDatabase;
	}
	
	
	/*
	 * Liste aus Emails aus der Datenbank
	 * 
	 * */
	public ArrayList<String> emailsFromDatabase() {
		String query = "SELECT Email FROM customers";
		emailsFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				emailsFromDatabase.add(result.getString(1));
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailsFromDatabase;
	}
	
	
	/*
	 * Liste aus TelNr aus der Datenbank
	 * 
	 * */
	public ArrayList<String> telNrFromDatabase() {
		String query = "SELECT Telefonnummer FROM customers";
		telNrsFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				telNrsFromDatabase.add(result.getString(1));
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return telNrsFromDatabase;
	}
	
	/*
	 * Liste aus Titel aus der Datenbank
	 * 
	 * */
	public ArrayList<String> degreesFromDatabase() {
		String query = "SELECT Titel FROM customers";
		degreesFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				degreesFromDatabase.add(result.getString(1));
			}
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return degreesFromDatabase;
	}
	
	/*
	 * Liste aus Verabredungstagen aus der Datenbank
	 * 
	 * */
	public ArrayList<String> meetingDaysFromDatabase() {
		String query = "SELECT AuftragDatum FROM customers";
		meetDaysFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				meetDaysFromDatabase.add(result.getString(1));
			}
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return meetDaysFromDatabase;
	}
	

	/*
	 * Liste aus Geschlechtern aus der Datenbank
	 * 
	 * */
	public ArrayList<String> gendersFromDatabase() {
		String query = "SELECT Geschlecht FROM customers";
		gendersFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				gendersFromDatabase.add(result.getString(1));
				
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gendersFromDatabase;
	}


	
	/*DAS SIND GETTER*/
	public ArrayList<String> getFirstNamesFromDatabase() {
		return firstNamesFromDatabase;
	}
	public ArrayList<String> getLastNamesFromDatabase() {
		return lastNamesFromDatabase;
	}
	public ArrayList<String> getEmailsFromDatabase() {
		return emailsFromDatabase;
	}
	public ArrayList<String> getBirthdaysFromDatabase() {
		return birthdaysFromDatabase;
	}
	public ArrayList<String> getTelNrsFromDatabase() {
		return telNrsFromDatabase;
	}
	public ArrayList<String> getDegreesFromDatabase() {
		return degreesFromDatabase;
	}
	public ArrayList<String> getMeetingDaysFromDatabase() {
		return meetDaysFromDatabase;
	}
	public ArrayList<String> getGendersFromDatabase() {
		return gendersFromDatabase;
	}
}

