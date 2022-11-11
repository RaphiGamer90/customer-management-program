package manager.errors;

import java.util.ArrayList;
import java.util.HashMap;

import controllers.Controller;

public class ErrorManager {

	Controller controller = new Controller();
	private HashMap<String, String> managementErrorMessages = new HashMap<>();
	private HashMap<String, String> birthdayErrorMessages = new HashMap<>();
	private ArrayList<String> errorMessages = new ArrayList<>();

	public ErrorManager() {
		initialiseAllErrorMessages();
	}

	public void initialiseAllErrorMessages() {
		managementErrorMessages.put("firstNameError", "Das ist kein Vorname!\n");
		managementErrorMessages.put("lastNameError", "Das ist kein Nachname!\n");
		managementErrorMessages.put("birthdayError", "Das ist kein Geburtstag!\n");
		managementErrorMessages.put("emailError", "Das ist keine E-Mail!\n");
		managementErrorMessages.put("emailExists", "Diese E-Mail existiert bereits!\n");
		managementErrorMessages.put("telNrError", "Das ist keine Telefonnummer!\n");
		managementErrorMessages.put("telNrExists", "Diese Telefonnummer existiert bereits!\n");
		managementErrorMessages.put("degreeError", "Das ist kein Titel!\n");
		managementErrorMessages.put("meetingDayError", "Das ist kein Datum!\n");
		managementErrorMessages.put("genderError", "Das ist kein passendes Geschlecht!\n");
		managementErrorMessages.put("emailNotExists", "Diese E-Mail existiert nicht in der Tabelle!\n");
	}
	
	
	public void throwErrors() {
		String errorMessage = "";
		for(String error : errorMessages) {
			errorMessage += error;
		}
		clearErrorMessagesArea();
		controller.getMainController().errorArea.setText(errorMessage);
		errorMessages.clear();
	}
	
	
	public void clearErrorMessagesArea() {
		controller.getMainController().errorArea.clear();
	}

	public HashMap<String, String> getManagementErrorMessages() {
		return managementErrorMessages;
	}
	
	public ArrayList<String> getErrorMessages() {
		return errorMessages;
	}
	
}
