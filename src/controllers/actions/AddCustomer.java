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

		
		if(!(controller.getMainController().managementErrorArea.getText() == "")) {
			return;
		}
		else {
			controller.getMainController().putInDatabase.putInDatabase(firstName, lastName, birthday, email, telNr, degree, meetingDay, gender);
			controller.getMainController().tableManager.refreshWholeTableView();
			controller.getMainController().errorManager.clearErrorMessagesArea();
		}
	}
			
	
	
	/*RETURN ALL THE CHECKED CUSTOMER DATA*/
	private String setFirstName(String firstName) {
		if(!isFirstName(firstName)) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Vorname!\n");
		}
		return firstName;
	}

	private String setLastName(String lastName) {
		if(!isLastName(lastName)) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Nachname!\n");
		}
		return lastName;
	}
	
	private String setBirthday(String birthday) {
		if(!isBirthday(birthday)) {
			controller.getMainController().errorManager.throwErrors("Das ist kein richtiges Datum!\n");
			
		}
		return birthday;
	}
	
	private String setEmail(String email) {
		if(!isEmail(email)) {
			controller.getMainController().errorManager.throwErrors("Das ist keine E-Mail!\n");
		}
		else if(controller.getMainController().dataManager.getReloadedEmails().contains(email)) {
			controller.getMainController().errorManager.throwErrors("Diese E-Mail ist bereits eingetragen!\n");
		}
		return email;
	}
	
	private String setTelNr(String telNr) {
		if(!isTelNr(telNr)) {
			controller.getMainController().errorManager.throwErrors("Das ist keine Telefonnummer!\n");
		}
		else if(controller.getMainController().dataManager.getReloadedTelNrs().contains(telNr)) {
			controller.getMainController().errorManager.throwErrors("Diese Telefonnummer gibt es schon!\n");
		}
		return telNr;
	}
	
	private String setDegree(String degree) {
		if(!isDegree(degree)) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Titel!\n");
		}
		return degree;
	}
	
	private String setMeetDay(String meetingDay) {
		if(!isMeetingDay(meetingDay)) {
			controller.getMainController().errorManager.throwErrors("Das ist kein richtiges Datum!\n");
		}
		return meetingDay;
	}
	
	private String setGender(String gender) {
		if(!isGender(gender)) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Geschlecht, glaub ich!\n");
		}
		return gender;
	}
		
}
