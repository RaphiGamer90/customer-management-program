package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DataFromDatabase {

	ArrayList<String> firstNamesFromDatabase = new ArrayList<>();
	ArrayList<String> lastNamesFromDatabase = new ArrayList<>();
	ArrayList<String> birthdaysFromDatabase = new ArrayList<>();
	ArrayList<String> emailsFromDatabase = new ArrayList<>();
	ArrayList<String> telNrFromDatabase = new ArrayList<>();
	ArrayList<String> degreeFromDatabase = new ArrayList<>();
	ArrayList<String> meetDaysFromDatabase = new ArrayList<>();
	ArrayList<String> gendersFromDatabase = new ArrayList<>();
	
	String query = "select * from customers";
	
	public void initialiseAllLists() {
		firstNamesFromDatabase();
		lastNamesFromDatabase();
		birthdayFromDatabase();
		emailFromDatabase();
		telNrFromDatabase();
		degreesFromDatabase();
		meetingDaysFromDatabase();
		genderFromDatabase();
	}
	
	/*
	 * Liste aus Vornamen aus der Datenbank
	 * 
	 * */
	public ArrayList<String> firstNamesFromDatabase() {
		firstNamesFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				firstNamesFromDatabase.add(result.getString("Vorname"));
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
		lastNamesFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				lastNamesFromDatabase.add(result.getString("Nachname"));
				
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
	public ArrayList<String> birthdayFromDatabase() {
		birthdaysFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				birthdaysFromDatabase.add(result.getString("Geburtstag"));
				
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
	public ArrayList<String> emailFromDatabase() {
		emailsFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				emailsFromDatabase.add(result.getString("Email"));
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
		telNrFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				telNrFromDatabase.add(result.getString("Telefonnummer"));
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return telNrFromDatabase;
	}
	
	/*
	 * Liste aus Titel aus der Datenbank
	 * 
	 * */
	public ArrayList<String> degreesFromDatabase() {
		degreeFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				degreeFromDatabase.add(result.getString("Titel"));
			}
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return degreeFromDatabase;
	}
	
	/*
	 * Liste aus Verabredungstagen aus der Datenbank
	 * 
	 * */
	public ArrayList<String> meetingDaysFromDatabase() {
		meetDaysFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				meetDaysFromDatabase.add(result.getString("AuftragDatum"));
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
	public ArrayList<String> genderFromDatabase() {
		gendersFromDatabase.clear();
		try {
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while(result.next()) {
				gendersFromDatabase.add(result.getString("Geschlecht"));
				
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
	public ArrayList<String> getTelNrFromDatabase() {
		return telNrFromDatabase;
	}
	public ArrayList<String> getDegreesFromDatabase() {
		return degreeFromDatabase;
	}
	public ArrayList<String> getMeetingDaysFromDatabase() {
		return meetDaysFromDatabase;
	}
	public ArrayList<String> getGendersFromDatabase() {
		return gendersFromDatabase;
	}
}

