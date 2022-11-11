package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.Controller;
import manager.data.DataManager;


public class PutInDatabase {

	Controller controller = new Controller();
	
	//Es werden die Werte, die in die Felder auf der GUI eingtragen werden, in die Datenbank hinzugefügt
	public void putInDatabase(String firstName, String lastName, String birthday, String email, String telNr, String degree, String meetingDay, String gender) {
		String queryLookThrough = "select * from customers";
				
		try {
			ConnectionToDatabase.preparedStatement(queryLookThrough).executeQuery();
		
			if(!controller.getMainController().dataManager.getUnloadedEmails().contains(email) || email == null) {
				String queryPutIn = "INSERT INTO customers VALUES ('" + firstName + "', '" + lastName + "', '" + birthday + "', '" + email + "', '" + telNr + "','" + degree + "','" + meetingDay + "','" + gender + "');";
				
				PreparedStatement statementToPutIn = ConnectionToDatabase.preparedStatement(queryPutIn);    
				statementToPutIn.executeUpdate(); 
			}					
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Es wird ein neuer Wert in der Datenbank eingesetzt, wenn die Bedingungen richtig sind
	public void setValueInDatabase(String column, String value, String firstName, String lastName, String birthday, String email, String telNr, String degree, String meetingDay, String gender) {		
		try {
			String queryEditValue = "UPDATE customers SET " + column + "='" + value + "' WHERE (Vorname='" + firstName + "' AND Nachname='" + lastName + "' AND Geburtstag='" + birthday + "' "
					+ "AND Email='" + email + "'" + "AND Telefonnummer='" + telNr + "' AND Titel='" + degree + "' AND AuftragDatum='" + meetingDay + "' AND Geschlecht='" + gender + "');";
			ConnectionToDatabase.preparedStatement(queryEditValue).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}
