package controllers.actions;

import java.util.ArrayList;
import java.util.HashMap;

import manager.checking.Checker;
import database.PutInDatabase;
import database.ValuesFromDatabase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import manager.loading.dataFromDatabase.LoadEmails;
import manager.loading.dataFromDatabase.LoadTelNrs;

public class AddCustomer {
	
	Checker checker = new Checker();
	HashMap<String, String> errorMap = new HashMap<>();
	
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
	
	
	
	
	
	private String setFirstName(TextField firstNameField) {
		if(firstNameField.getText().isEmpty() 
				|| !checker.isString(firstNameField.getText()) 
				|| !checker.isFirstLetterUpperCase(firstNameField.getText())) {
			return errorMap.put("firstNameErrorMessage", "Das ist kein Vorname!\n");
		}
//		System.out.println(firstNameField.getText());
		return firstNameField.getText();
	}
	
	private String setLastName(TextField lastNameField) {
		if(lastNameField.getText().isEmpty() 
				|| !checker.isString(lastNameField.getText()) 
				|| !checker.isFirstLetterUpperCase(lastNameField.getText())) {
			return errorMap.put("lastNameErrorMessage", "Das ist kein Nachname!\n");
		}
//		System.out.println(lastNameField.getText());
		return lastNameField.getText();
	}
	
	private String setBirthday(String birthdayField) {
		if(birthdayField.isEmpty() || !checker.isDateWithoutYear(birthdayField) || !checker.isDateWithYear(birthdayField)) {
			return errorMap.put("birthdayErrorMessage", "Das ist kein Geburtstag!\n");
		}
//		System.out.println(birthdayField);
		return birthdayField;
	}
	
	private String setEmail(TextField emailField) {
		LoadEmails loadEmails = new LoadEmails();
		if(emailField.getText().isEmpty() || !checker.isValidEmail(emailField.getText())) {
			return errorMap.put("emailErrorMessage", "Das ist keine E-Mail!\n");
		}
		else if(loadEmails.getLoadetEmails().contains(emailField.getText())) {
			return errorMap.put("emailErrorMessage", "Diese E-Mail existiert bereits!\n");
		}
//		System.out.println(emailField.getText());
		return emailField.getText();
	}
	
	private String setTelNr(TextField telNrField) {
		LoadTelNrs loadTelNrs = new LoadTelNrs();
		if(telNrField.getText().isEmpty() || !checker.isValidTelephonenumberWithoutPlus(telNrField.getText()) || !checker.isValidTelephonenumberWithPlus(telNrField.getText())) {
			return errorMap.put("telNrErrorMessage", "Das ist keine Telefonnummer!\n");
		}
		else if(loadTelNrs.getLoadetTelNrs().contains(telNrField.getText())) {
			return errorMap.put("telNrErrorMessage", "Diese Telefonnummer existiert bereits!\n");
		}
//		System.out.println(telNrField.getText());
		return telNrField.getText();
	}
	
	private String setDegree(TextField degreeField) {
		if(degreeField.getText().isEmpty()) {
			return errorMap.put("degreeErrorMessage", "Das ist kein Titel!\n");
		}
//		System.out.println(degreeField.getText());
		return degreeField.getText();
	}
	
	private String setMeetDay(String meetingDayField) {
		if(meetingDayField.isEmpty() || !checker.isDateWithoutYear(meetingDayField) || !checker.isDateWithYear(meetingDayField)) {
			return errorMap.put("meetingDayErrorMessage", "Das ist kein Datum!\n");
		}
//		System.out.println(meetingDayField);
		return meetingDayField;
	}
	
	private String setGender(ComboBox<String> genderBox) {
		if(genderBox.getSelectionModel().isEmpty() || !checker.isValidGender(genderBox.getValue())) {
			return errorMap.put("genderErrorMessage", "Das ist kein passendes Geschlecht!\n");
		}
//		System.out.println(genderBox.getValue().toString() + " " + genderBox.getSelectionModel().getSelectedItem());
		return genderBox.getValue();
	}
		
}
