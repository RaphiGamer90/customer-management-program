package controllers.actions;

import controllers.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import manager.checking.CustomerDataCheckerManager;


public class AddCustomer extends CustomerDataCheckerManager {

	Controller controller = new Controller();
	public boolean confirmErrorPopUp;
	
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
		if(!isFirstName(firstName) && !(firstName == null|| firstName.isBlank())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Vorname!\n");
		}
		return firstName;
	}

	private String setLastName(String lastName) {
		if(!isLastName(lastName) && !(lastName == null || lastName.isBlank())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Nachname!\n");
		}
		return lastName;
	}
	
	private String setBirthday(String birthday) {
		if(!isBirthday(birthday) && !(birthday == null || birthday.isBlank())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein richtiges Datum!\n");
		}
		return birthday;
	}
	
	private String setEmail(String email) {
		if(!isEmail(email) && !(email == null || email.isBlank())) {
			controller.getMainController().errorManager.throwErrors("Das ist keine E-Mail!\n");
		}
		else if(controller.getMainController().dataManager.getReloadedEmails().contains(email)) {
			controller.getMainController().errorManager.throwPopUpError("Diese E-Mail ist bereits eingetragen! (ACHTUNG BEIM LÖSCHEN!)\n");
			
		}		
		return email;
	}
	
	private String setTelNr(String telNr) {
		if(!isTelNr(telNr) && !(telNr == null || telNr.isBlank())) {
			controller.getMainController().errorManager.throwErrors("Das ist keine Telefonnummer!\n");
		}
		else if(controller.getMainController().dataManager.getReloadedTelNrs().contains(telNr)) {
			controller.getMainController().errorManager.throwPopUpError("Diese Telefonnummer gibt es schon! (AUFPASSEN!)\n");	
			
			
		}
		return telNr;
	}
	
	private String setDegree(String degree) {
		if(!isDegree(degree) && !(degree == null || degree.isBlank())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Titel!\n");
		}
		return degree;
	}
	
	private String setMeetDay(String meetingDay) {
		if(!isMeetingDay(meetingDay) && !(meetingDay == null|| meetingDay.isBlank())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein richtiges Datum!\n");
		}
		return meetingDay;
	}
	
	private String setGender(String gender) {
		if(!isGender(gender) && !(gender == null || gender.isBlank())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Geschlecht, glaub ich!\n");
		}
		return gender;
	}
		
}
