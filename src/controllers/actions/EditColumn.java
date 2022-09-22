package controllers.actions;

import manager.checking.Checker;
import manager.checking.CustomerDataChecker;
import manager.data.DataManager;
import manager.loading.LoadManager;

import java.awt.TextArea;
import java.util.HashMap;

import database.PutInDatabase;
import javafx.scene.control.TableColumn.CellEditEvent;
import manager.models.TableModel;
import manager.tableView.TableManager;

public class EditColumn {
	
	CustomerDataChecker customerDataChecker = new CustomerDataChecker();
	HashMap<String, String> errorMap = new HashMap<>();
	PutInDatabase editValue = new PutInDatabase();
	DataManager dataManager = new DataManager();
	LoadManager loadManger = new LoadManager(); 
	TableManager tableManager = new TableManager();
	
	public void editFirstNameColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!customerDataChecker.isFirstName(event.getNewValue())) {
			errorMap.put("firstNameErrorMessage", "Das ist kein richtiger Vorname!");
			return;
		}
		 
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		tableManager.refreshFirstNameColumn();
	}
	
	
	public void editLastNameColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!customerDataChecker.isLastName(event.getNewValue())) {
			errorMap.put("firstNameErrorMessage", "Das ist kein richtiger Nachname!");
			return;
		}
		
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	

	public void editBirthdayColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!customerDataChecker.isBirthday(event.getNewValue())) {
			errorMap.put("birthdayErrorMessage", "Das ist kein richtiger Geburstag!");
			return;
		}
		
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}

	
	public void editEmailColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!customerDataChecker.isEmail(event.getNewValue())) {
			errorMap.put("emailErrorMessage", "Das ist keine richtige E-Mail!");
			return;
		}
		else if(dataManager.getUnloadedEmails().contains(event.getNewValue())) {
			errorMap.put("emailErrorMessage", "Diese E-Mail exisitiert bereits!");
			return;
		}
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	
	
	public void editTelNr(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!customerDataChecker.isTelNr(event.getNewValue())) {
			errorMap.put("telNrErrorMap", "Das ist keine richtige Telefonnummer!");
			return;
		}
		else if(dataManager.getUnloadedTelNrs().contains(event.getNewValue())) {
			errorMap.put("telNrErrorMap", "Diese Telefonnummer existiert bereits!");
			return;
		}
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	
	
	public void editDegree(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!customerDataChecker.isDegree(event.getNewValue())) {
			errorMap.put("degreeErrorMessage", "Das ist kein richtiger Titel!");
			return;
		}
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	
	
	public void editMeetingDayColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!customerDataChecker.isMeetingDay(event.getNewValue())) {
			errorMap.put("meetindDayErrorMessage", "Das ist kein richtiges Datum!");
			return;
		}
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}
	
	
	public void editGenderColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!customerDataChecker.isGender(event.getNewValue())) {
			errorMap.put("genderErrorMessage", "Das ist kein richtiges Geschlecht! (Glaube ich)");
			return;
		}
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
	}


	public HashMap<String, String> getErrorMap() {
		return errorMap;
	}


}
