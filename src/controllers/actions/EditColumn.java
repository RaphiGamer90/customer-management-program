package controllers.actions;

import manager.checking.Checker;
import manager.checking.CustomerDataChecker;
import manager.data.DataManager;
import manager.loading.MainLoadingManager;
import manager.loading.dataFromDatabase.LoadWholeDatabase;

import java.awt.TextArea;
import java.util.HashMap;

import database.PutInDatabase;
import javafx.scene.control.TableColumn.CellEditEvent;
import manager.models.TableModel;

public class EditColumn {
	
	CustomerDataChecker customerDataChecker = new CustomerDataChecker();
	HashMap<String, String> errorMap = new HashMap<>();
	PutInDatabase editValue = new PutInDatabase();
	DataManager dataManage = new DataManager();
	
	
	public void editFirstNameColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		dataManage.getFirstNames();
		if(!customerDataChecker.isFirstName(event.getNewValue())) {
			errorMap.put("firstNameErrorMessage", "Das ist kein richtiger Vorname!");
			return;
		}
		 
		editValue.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		
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
		else if(dataManage.getEmails().contains(event.getNewValue())) {
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
		else if(dataManage.getTelNrs().contains(event.getNewValue())) {
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
	
	

//
//	public void degreeColumnEdit(CellEditEvent<TableModel, String> event) {
//		TableModel value = event.getRowValue();
//		
//		if (checker.isValidEmail(value.getEmail())) {
//			if (checker.isInteger(event.getNewValue())) {
//				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
//				loadData();
//				errorArea.setText("");
//			} else {			
//				errorArea.setText(event.getNewValue() + " ist keine Zahl!");
//			}
//		}
//		
//	}
//
//	public void meetingDayColumnEdit(CellEditEvent<TableModel, String> event) {
//		TableModel value = event.getRowValue();
//		
//		if (checker.isValidEmail(value.getEmail())) {
//			if (checker.isDateWithoutYear(event.getNewValue())
//					|| checker.isDateWithYear(event.getNewValue())) {
//				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
//				loadData();
//				errorArea.setText("");
//			} else {
//				errorArea.setText(event.getNewValue() + " ist kein richtiges Datum!");
//			}
//		}
//	}
//
//	public void genderColumnEdit(CellEditEvent<TableModel, String> event) {
//		TableModel value = event.getRowValue();
//		
//		if (checker.isValidEmail(value.getEmail())) {
//			if (checker.isValidGender(event.getNewValue())) {
//				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
//				loadData();
//				errorArea.setText("");
//			} else {
//				errorArea.setText("Das ist kein Geschlecht! (Glaube ich) :^D");
//			}
//		}
//	}

}
