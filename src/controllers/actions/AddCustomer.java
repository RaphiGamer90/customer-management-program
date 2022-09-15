package controllers.actions;

import java.util.ArrayList;
import java.util.HashMap;

import manager.checking.Checker;
import manager.checking.CustomerDataChecker;
import manager.data.DataManager;
import database.PutInDatabase;
import database.DataFromDatabase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class AddCustomer {
	
	private CustomerDataChecker customerDataChecker = new CustomerDataChecker();
	private HashMap<String, String> errorMap = new HashMap<>();
	DataManager dataManager = new DataManager();
	
	/*SET ALL THE CUSTOMER DATA*/
	public void setCustomerInDatabase(TextField firstNameField, TextField lastNameField, TextField emailField, String birthdayField, TextField telNrField, 
			TextField degreeField, String meetingDayField, ComboBox<String> genderBox, TextArea errorArea) {
		
		String firstName = setFirstName(firstNameField);
		String lastName = setLastName(lastNameField);
		String birthday = setBirthday(birthdayField);
		String email = setEmail(emailField);
		String telNr = setTelNr(telNrField);
		String degree = setDegree(degreeField);
		String meetingDay = setMeetDay(meetingDayField);
		String gender = setGender(genderBox);
		
		if(!errorMap.isEmpty()) {
			String errorMessage = "";
			for(String error : errorMap.values()) {
				errorMessage += error;
				errorArea.setText(errorMessage);
			}
		}
		else {
			PutInDatabase addCustomer = new PutInDatabase();
			System.out.println("Konnte erfolgreich abgeschickt werden.");
			addCustomer.putInDatabase(firstName, lastName, birthday, email, telNr, degree, meetingDay, gender);
		}
	}
			
	
	
	/*RETURN ALL THE CHECKED CUSTOMER DATA*/
	private String setFirstName(TextField firstNameField) {
		if(!customerDataChecker.isFirstName(firstNameField.getText())) {
			return errorMap.put("firstNameErrorMessage", "Das ist kein Vorname!\n");
		}
		return firstNameField.getText();
	}
	
	private String setLastName(TextField lastNameField) {
		if(!customerDataChecker.isLastName(lastNameField.getText())) {
			return errorMap.put("lastNameErrorMessage", "Das ist kein Nachname!\n");
		}
		return lastNameField.getText();
	}
	
	private String setBirthday(String birthdayField) {
		if(!customerDataChecker.isBirthday(birthdayField.trim())) {
			return errorMap.put("birthdayErrorMessage", "Das ist kein Geburtstag!\n");
		}
		return birthdayField;
	}
	
	private String setEmail(TextField emailField) {
		if(!customerDataChecker.isEmail(emailField.getText())) {
			return errorMap.put("emailErrorMessage", "Das ist keine E-Mail!\n");
		}
		else if(dataManager.getUnloadedEmails().contains(emailField.getText())) {
			return errorMap.put("emailErrorMessage", "Diese E-Mail existiert bereits!\n");
		}
		return emailField.getText();
	}
	
	private String setTelNr(TextField telNrField) {
		if(!customerDataChecker.isTelNr(telNrField.getText())) {
			return errorMap.put("telNrErrorMessage", "Das ist keine Telefonnummer!\n");
		}
		else if(dataManager.getUnloadedTelNrs().contains(telNrField.getText())) {
			return errorMap.put("telNrErrorMessage", "Diese Telefonnummer existiert bereits!\n");
		}
		return telNrField.getText();
	}
	
	private String setDegree(TextField degreeField) {
		if(!customerDataChecker.isDegree(degreeField.getText())) {
			return errorMap.put("degreeErrorMessage", "Das ist kein Titel!\n");
		}
		return degreeField.getText();
	}
	
	private String setMeetDay(String meetingDayField) {
		if(!customerDataChecker.isBirthday(meetingDayField.trim())) {
			return errorMap.put("meetingDayErrorMessage", "Das ist kein Datum!\n");
		}
		return meetingDayField;
	}
	
	private String setGender(ComboBox<String> genderBox) {
		if(!customerDataChecker.isGender(genderBox.getValue())) {
			return errorMap.put("genderErrorMessage", "Das ist kein passendes Geschlecht!\n");
		}
		return genderBox.getValue();
	}
		
}
