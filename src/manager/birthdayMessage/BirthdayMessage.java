package manager.birthdayMessage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import manager.checking.Checker;
import database.ConnectionToDatabase;


public class BirthdayMessage {
	
	String salutation, content, adoption;
	ArrayList<String> birthdayEmailList = new ArrayList<>();
	ArrayList<String> birthdayMessage = new ArrayList<>();
	int customerID;
	ConnectionToDatabase connectionToDatabase = new ConnectionToDatabase();
	Checker checker = new Checker();
	
	
	/*
	 * Es wird eine Geburtstagsmail geschrieben
	 * 
	 * */
	public BirthdayMessage() {
		
		String query = "select * from customers"; 		
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.");  
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd.MM.yyyy");  
		Date date = new Date(); 
	
		
		try {
			
			ResultSet result = ConnectionToDatabase.preparedStatement(query).executeQuery();
			boolean isBirthday = false;
			
			//The Database gets interated through
			while(result.next()) {
				String firstName = result.getString("Vorname");
				String lastName = result.getString("Nachname");
				String birthday = result.getString("Geburtstag");
				String email = result.getString("Email");
				String telephonenumber = result.getString("Telefonnummer");
				String gender = result.getString("Geschlecht");
				
				
				if(birthday.equals("000")) {
					return;	
				}
				else {
					//Checking if the Data of the Customer contains the todays Date AND the e-mail is a real e-mail
					if(checker.isDateWithoutYear(birthday) || checker.isDateWithYear(birthday)) {
						if(birthday.equals(formatter1.format(date)) || birthday.equals(formatter2.format(date))) {
							if(checker.isValidEmail(email) && gender.equals("Herr")) {
								
								String message = "Lieber " + firstName + " " + lastName + "," + " \n\n" + "Ich wünsche dir alles Gute zu deinem Geburtstag!" 
										+ " \n\n" + "Liebe Grüße," + " \n" + "Frau Mag. Gabriela Zangl-Gottwald!";
								
								birthdayEmailList.add(email);
								birthdayMessage.add(message);
								isBirthday = true;	
							}
						}
					}


					if(checker.isDateWithoutYear(birthday) || checker.isDateWithYear(birthday)) {
						if(birthday.equals(formatter1.format(date)) || birthday.equals(formatter2.format(date))) {
							if(checker.isValidEmail(email) && gender.equals("Frau")) {
								
								String message = "Liebe " + firstName + " " + lastName + "," + " \n\n" + "Ich wünsche dir alles Gute zu deinem Geburtstag!"
										+ " \n\n" + "Liebe Grüße," + " \n" + "Frau Mag. Gabriela Zangl-Gottwald!";
									

								birthdayEmailList.add(email);
								birthdayMessage.add(message);
								isBirthday = true;			
							}
						}
					}
					
					if(checker.isDateWithoutYear(birthday) || checker.isDateWithYear(birthday)) {
						if(birthday.equals(formatter1.format(date)) || birthday.equals(formatter2.format(date))) {
							if(checker.isValidEmail(email) && gender.equals("Divers")) {
								
								String message = "Liebe/r " + firstName + " " + lastName + "," + " \n\n" + "Ich wünsche dir alles Gute zu deinem Geburtstag!"
										+ " \n\n" + "Liebe Grüße," + " \n" + "Frau Mag. Gabriela Zangl-Gottwald!";
									
								birthdayEmailList.add(email);
								birthdayMessage.add(message);
								isBirthday = true;
							}
						}
					}
					
					if(checker.isDateWithoutYear(birthday) || checker.isDateWithYear(birthday)) {
						if(birthday.equals(formatter1.format(date)) || birthday.equals(formatter2.format(date))) {
							if(checker.isValidEmail(email) && gender.equals("Unknown")) {
								
								String message = "Liebe/r " + firstName + " " + lastName + "," + " \n\n" + "Ich wünsche dir alles Gute zu deinem Geburtstag!"
										+ " \n\n" + "Liebe Grüße," + " \n" + "Frau Mag. Gabriela Zangl-Gottwald!";
									
								birthdayEmailList.add(email);
								birthdayMessage.add(message);
								isBirthday = true;
							}
						}
					}
				}
			}
			if (isBirthday == false) {
				String message = "Es hat heute niemand GEBURTSTAG!\nSchau ein anderes Mal wieder vorbei!\nLG ihr EntwicklerTeam!";
				birthdayMessage.add(message);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    
    //Getters for the Customers


	public ArrayList<String> getBirthdayMessage() {
		return birthdayMessage;
	}
	public ArrayList<String> getBirthdayEmailList() {
		return birthdayEmailList;
	}
	
	
	
}
