package controllers.actions;

import java.util.ArrayList;
import java.util.HashMap;

import controllers.Controller;
import controllers.MainController;
import manager.checking.CustomerDataCheckerManager;
import manager.data.DataManager;
import database.PutInDatabase;
import database.DataFromDatabase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class AddCustomer extends CustomerDataCheckerManager {

	Controller controller = new Controller();
	
	private HashMap<String, String> errorMap = new HashMap<>();

	
	/*SET ALL THE CUSTOMER DATA*/
	public void setCustomerInDatabase() {
		
		String firstName = setFirstName(controller.getMainController().firstNameField.getText());
		String lastName = setLastName(controller.getMainController().lastNameField.getText());
		String birthday = setBirthday(controller.getMainController().datePickerManager.getBirthdayDatePickerValue());
		String email = setEmail(controller.getMainController().emailField.getText());
		String telNr = setTelNr(controller.getMainController().telephoneField.getText());
		String degree = setDegree(controller.getMainController().degreeField.getText());
		String meetingDay = setMeetDay(controller.getMainController().datePickerManager.getMeetingDayDatePickerValue());
		String gender = setGender(controller.getMainController().genderBox.getValue());
		
		if(!errorMap.isEmpty()) {
			String errorMessage = "";
			for(String error : errorMap.values()) {
				errorMessage += error;
				controller.getMainController().errorArea.setText(errorMessage);
			}
		}
		else {
			controller.getMainController().putInDatabase.putInDatabase(firstName, lastName, birthday, email, telNr, degree, meetingDay, gender);
		}
	}
			
	
	
	/*RETURN ALL THE CHECKED CUSTOMER DATA*/
	private String setFirstName(String firstName) {
		if(!isFirstName(firstName)) {
			return errorMap.put("firstNameErrorMessage", "Das ist kein Vorname!\n");
		}
		return firstName;
	}

	private String setLastName(String lastName) {
		if(!isLastName(lastName)) {
			return errorMap.put("lastNameErrorMessage", "Das ist kein Nachname!\n");
		}
		return lastName;
	}
	
	private String setBirthday(String birthday) {
		if(!isBirthday(birthday.trim())) {
			return errorMap.put("birthdayErrorMessage", "Das ist kein Geburtstag!\n");
		}
		return birthday;
	}
	
	private String setEmail(String email) {
		if(!isEmail(email)) {
			return errorMap.put("emailErrorMessage", "Das ist keine E-Mail!\n");
		}
		else if(controller.getMainController().dataManager.getReloadedEmails().contains(email)) {
			return errorMap.put("emailErrorMessage", "Diese E-Mail existiert bereits!\n");
		}
		return email;
	}
	
	private String setTelNr(String telNr) {
		if(!isTelNr(telNr.trim())) {
			return errorMap.put("telNrErrorMessage", "Das ist keine Telefonnummer!\n");
		}
		else if(controller.getMainController().dataManager.getReloadedTelNrs().contains(telNr)) {
			return errorMap.put("telNrErrorMessage", "Diese Telefonnummer existiert bereits!\n");
		}
		return telNr;
	}
	
	private String setDegree(String degree) {
		if(!isDegree(degree)) {
			return errorMap.put("degreeErrorMessage", "Das ist kein Titel!\n");
		}
		return degree;
	}
	
	private String setMeetDay(String meetingDay) {
		if(!isBirthday(meetingDay.trim())) {
			return errorMap.put("meetingDayErrorMessage", "Das ist kein Datum!\n");
		}
		return meetingDay;
	}
	
	private String setGender(String gender) {
		if(!isGender(gender.trim())) {
			return errorMap.put("genderErrorMessage", "Das ist kein passendes Geschlecht!\n");
		}
		return gender;
	}
		
}
