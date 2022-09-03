package controllers.actions;

import manager.checking.Checker;

import java.awt.TextArea;
import java.util.HashMap;

import database.PutInDatabase;
import javafx.scene.control.TableColumn.CellEditEvent;
import manager.models.TableModel;

public class EditColumn {
	Checker checker = new Checker();
	HashMap<String, String> errorMap = new HashMap<>();
	PutInDatabase editValue = new PutInDatabase();
	
	public void firstNameColumnEdit(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		
		if (checker.isValidEmail(value.getEmail())) {
			if (checker.isFirstLetterUpperCase(event.getNewValue())) {
				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
				loadData();
				errorArea.setText("");
			} else {
				errorArea.setText("Das ist kein richtiger Nachname!");
			}
		}
		
	}
	
	
	private void editFirstNameColumn(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		String firstName = event.getNewValue();
		
		if(!checker.isString(firstName) && !checker.isFirstLetterUpperCase(firstName)) {
			errorMap.put("editFirstNameErrorMessage", "");
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void lastNameColumnEdit(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();

		if (checker.isValidEmail(value.getEmail())) {
			if (checker.isFirstLetterUpperCase(event.getNewValue())) {
				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
				loadData();
				errorArea.setText("");
			} else {
				errorArea.setText("Das ist kein richtiger Nachname!");
			}
		}
	}

	public void birthdayColumnEdit(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if (checker.isValidEmail(value.getEmail())) {
			if (checker.isDateWithoutYear(event.getNewValue()) || checker.isDateWithYear(event.getNewValue())) {
				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
				loadData();
				errorArea.setText("");
			} else {
				errorArea.setText(event.getNewValue() + " ist kein richtiges Datum!");
			}
		}
		
	}

	public void emailColumnEdit(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if (checker.isValidEmail(value.getEmail())) {
			if (checker.isValidEmail(event.getNewValue())) {
				if (!valuesFromDatabase.getEmailsFromDatabase().contains(event.getNewValue())) {
					putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
					loadData();
					errorArea.setText("");
				} else {
					errorArea.setText("Diese E-Mail gibt es bereits!");
				}
			} else {
				errorArea.setText("Das ist keine richtige E-Mail!");
			}
		}
	}

	public void telephoneColumnEdit(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if (checker.isValidEmail(value.getEmail())) {
			if (checker.isValidTelephonenumberWithoutPlus(event.getNewValue())
					|| checker.isValidTelephonenumberWithPlus(event.getNewValue())) {
				if (!valuesFromDatabase.getTelNrFromDatabase().contains(event.getNewValue())) {
					putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
					loadData();
					errorArea.setText("");
				} else {
					errorArea.setText(event.getNewValue() + " existiert bereits in der Datenbank!");
				}
			} else {
				errorArea.setText(event.getNewValue() + " ist keine richtige Telefonnummer!");
			}
		}
		
	}

	public void titleColumnEdit(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if (checker.isValidEmail(value.getEmail())) {
			if (checker.isInteger(event.getNewValue())) {
				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
				loadData();
				errorArea.setText("");
			} else {			
				errorArea.setText(event.getNewValue() + " ist keine Zahl!");
			}
		}
		
	}

	public void orderDateColumnEdit(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if (checker.isValidEmail(value.getEmail())) {
			if (checker.isDateWithoutYear(event.getNewValue())
					|| checker.isDateWithYear(event.getNewValue())) {
				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
				loadData();
				errorArea.setText("");
			} else {
				errorArea.setText(event.getNewValue() + " ist kein richtiges Datum!");
			}
		}
	}

	public void genderColumnEdit(CellEditEvent<TableModel, String> event) {
		TableModel value = event.getRowValue();
		
		if (checker.isValidEmail(value.getEmail())) {
			if (checker.isValidGender(event.getNewValue())) {
				putInDatabase.setValueInDatabase(event.getTableColumn().getText(), event.getNewValue(), value.getEmail());
				loadData();
				errorArea.setText("");
			} else {
				errorArea.setText("Das ist kein Geschlecht! (Glaube ich) :^D");
			}
		}
	}

}
