package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import manager.loading.dataFromDatabase.LoadEmails;


public class PutInDatabase {

	String queryLookThrough = "select * from customers";
	LoadEmails loadetEmails = new LoadEmails();
	
	//Es werden die Werte, die in die Felder auf der GUI eingtragen werden, in die Datenbank hinzugefügt
	public void putInDatabase(String firstName, String lastName, String birthday, String email, String telNr, String title, String orderDate, String gender) {
				
		try {
			ConnectionToDatabase.preparedStatement(queryLookThrough).executeQuery();
		
			if(!loadetEmails.getLoadetEmails().contains(email)) {
				String queryPutIn = "INSERT INTO customers VALUES ('" + firstName + "', '" + lastName + "', '" + birthday + "', '" + email + "', '" + telNr + "','" + title + "','" + orderDate + "','" + gender + "');";
				
				PreparedStatement statementToPutIn = ConnectionToDatabase.preparedStatement(queryPutIn);    
				statementToPutIn.executeUpdate(); 
				
			}					
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
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
