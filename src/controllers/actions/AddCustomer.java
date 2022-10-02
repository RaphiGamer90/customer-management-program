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
		
		if(!controller.getMainController().errorManager.getAddCustomerErrorMap().isEmpty()) {
			controller.getMainController().errorManager.throwAddCustomerErrors();
		}
		else {
			controller.getMainController().putInDatabase.putInDatabase(firstName, lastName, birthday, email, telNr, degree, meetingDay, gender);
			controller.getMainController().errorManager.clearErrorMessages();
		}
	}
			
	
	
	/*RETURN ALL THE CHECKED CUSTOMER DATA*/
	private String setFirstName(String firstName) {
		if(!isFirstName(firstName)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("firstNameErrorMessage", "Das ist kein Vorname!\n");
		}
		return firstName;
	}

	private String setLastName(String lastName) {
		if(!isLastName(lastName)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("lastNameErrorMessage", "Das ist kein Nachname!\n");
		}
		return lastName;
	}
	
	private String setBirthday(String birthday) {
		if(!isBirthday(birthday)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("birthdayErrorMessage", "Das ist kein Geburtstag!\n");
		}
		return birthday;
	}
	
	private String setEmail(String email) {
		if(!isEmail(email)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("emailErrorMessage", "Das ist keine E-Mail!\n");
		}
		else if(controller.getMainController().dataManager.getReloadedEmails().contains(email)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("emailErrorMessage", "Diese E-Mail existiert bereits!\n");
		}
		return email;
	}
	
	private String setTelNr(String telNr) {
		if(!isTelNr(telNr)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("telNrErrorMessage", "Das ist keine Telefonnummer!\n");
		}
		else if(controller.getMainController().dataManager.getReloadedTelNrs().contains(telNr)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("telNrErrorMessage", "Diese Telefonnummer existiert bereits!\n");
		}
		return telNr;
	}
	
	private String setDegree(String degree) {
		if(!isDegree(degree)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("degreeErrorMessage", "Das ist kein Titel!\n");
		}
		return degree;
	}
	
	private String setMeetDay(String meetingDay) {
		if(!isBirthday(meetingDay)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("meetingDayErrorMessage", "Das ist kein Datum!\n");
		}
		return meetingDay;
	}
	
	private String setGender(String gender) {
		if(!isGender(gender)) {
			return controller.getMainController().errorManager.getAddCustomerErrorMap().put("genderErrorMessage", "Das ist kein passendes Geschlecht!\n");
		}
		return gender;
	}
		
}
