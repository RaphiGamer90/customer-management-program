package controllers.actions;

import manager.checking.CustomerDataCheckerManager;
import manager.data.DataManager;
import manager.loading.LoadManager;

import java.awt.TextArea;
import java.util.HashMap;

import controllers.Controller;
import controllers.MainController;
import database.PutInDatabase;
import javafx.scene.control.TableColumn.CellEditEvent;
import manager.models.TableModel;
import manager.tableView.TableManager;

public class EditColumn extends CustomerDataCheckerManager {
	
	HashMap<String, String> errorMap = new HashMap<>();
	Controller controller = new Controller();

	
	public void editFirstNameColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isFirstName(event.getNewValue())) {
			errorMap.put("firstNameErrorMessage", "Das ist kein richtiger Vorname!");
			return;
		}
		 
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		controller.getMainController().tableManager.refreshFirstNameColumn();
	}
	

	public void editLastNameColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isLastName(event.getNewValue())) {
			errorMap.put("firstNameErrorMessage", "Das ist kein richtiger Nachname!");
			return;
		}
		
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		controller.getMainController().tableManager.refreshLastNameColumn();
	}
	

	public void editBirthdayColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isBirthday(event.getNewValue())) {
			errorMap.put("birthdayErrorMessage", "Das ist kein richtiger Geburstag!");
			return;
		}
		
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		controller.getMainController().tableManager.refreshBirthdayColumn();
	}

	
	public void editEmailColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isEmail(event.getNewValue())) {
			errorMap.put("emailErrorMessage", "Das ist keine richtige E-Mail!");
			return;
		}
		else if(controller.getMainController().dataManager.getUnloadedEmails().contains(event.getNewValue())) {
			errorMap.put("emailErrorMessage", "Diese E-Mail exisitiert bereits!");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	
	
	public void editTelNr(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isTelNr(event.getNewValue())) {
			errorMap.put("telNrErrorMap", "Das ist keine richtige Telefonnummer!");
			return;
		}
		else if(controller.getMainController().dataManager.getUnloadedTelNrs().contains(event.getNewValue())) {
			errorMap.put("telNrErrorMap", "Diese Telefonnummer existiert bereits!");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	
	
	public void editDegree(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isDegree(event.getNewValue())) {
			errorMap.put("degreeErrorMessage", "Das ist kein richtiger Titel!");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	
	
	public void editMeetingDayColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isMeetingDay(event.getNewValue())) {
			errorMap.put("meetindDayErrorMessage", "Das ist kein richtiges Datum!");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	
	
	public void editGenderColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isGender(event.getNewValue())) {
			errorMap.put("genderErrorMessage", "Das ist kein richtiges Geschlecht! (Glaube ich)");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}


	public HashMap<String, String> getErrorMap() {
		return errorMap;
	}


}
