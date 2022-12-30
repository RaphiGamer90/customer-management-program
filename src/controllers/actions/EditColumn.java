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
	
	Controller controller = new Controller();

	
	/**
	 * Es können alle Zellen der TableView einzeln bearbeitet werden 
	 * 
	 */
	
	public void editFirstNameColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isFirstName(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Vorname!\n");
			return;
		}
		 
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		controller.getMainController().tableManager.refreshFirstNameColumn();
	}
	

	public void editLastNameColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isLastName(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein Nachname!\n");
			return;
		}
		
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		controller.getMainController().tableManager.refreshLastNameColumn();
	}
	

	public void editBirthdayColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isBirthday(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein richtiges Datum!\n");
			return;
		}
		
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		controller.getMainController().tableManager.refreshBirthdayColumn();
	}

	
	public void editEmailColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isEmail(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Das ist keine richtige E-Mail!\n");
			return;
		}
		else if(controller.getMainController().dataManager.getUnloadedEmails().contains(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Diese E-Mail existiert bereits!\n");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
		controller.getMainController().tableManager.refreshEmailColumn();
	}
	
	
	public void editTelNr(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isTelNr(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Das ist keine richtige Telefonnummer!\n");
			return;
		}
		else if(controller.getMainController().dataManager.getUnloadedTelNrs().contains(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Diese Telefonnummer gibt es bereits!\n");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
				controller.getMainController().tableManager.refreshTelNrColumn();
	}
	
	
	public void editDegree(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isDegree(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein richtiger Titel!\n");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
				controller.getMainController().tableManager.refreshDegreeColumn();
	}
	
	
	public void editMeetingDayColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isMeetingDay(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein richtiges Datum!\n");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
				controller.getMainController().tableManager.refreshMeetingDayColumn();
	}
	
	
	public void editGenderColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if(!isGender(event.getNewValue())) {
			controller.getMainController().errorManager.throwErrors("Das ist kein richtiges Geschlecht, glaube ich!\n");
			return;
		}
		controller.getMainController().putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getFirstName(), value.getLastName(), 
				value.getBirthday(), value.getEmail(), value.getTelNr(), value.getDegree(), value.getMeetingDay(), value.getGender());
				controller.getMainController().tableManager.refreshGenderColumn();
	}
}
