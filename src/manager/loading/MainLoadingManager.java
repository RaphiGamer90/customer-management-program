package manager.loading;

import database.ValuesFromDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import manager.loading.dataFromDatabase.LoadBirthdays;
import manager.loading.dataFromDatabase.LoadDegrees;
import manager.loading.dataFromDatabase.LoadEmails;
import manager.loading.dataFromDatabase.LoadFirstNames;
import manager.loading.dataFromDatabase.LoadGenders;
import manager.loading.dataFromDatabase.LoadLastNames;
import manager.loading.dataFromDatabase.LoadMeetingDays;
import manager.loading.dataFromDatabase.LoadTelNrs;
import manager.loading.dataFromDatabase.LoadWholeDatabase;
import manager.loading.tableView.LoadWholeTableView;
import manager.models.TableModel;

public class MainLoadingManager {
	ObservableList<TableModel> searchModelObservableList = FXCollections.observableArrayList();

	public void loadFirstNames(ValuesFromDatabase valuesFromDatabase) {
		LoadFirstNames firstNames = new LoadFirstNames(valuesFromDatabase);
	}
	
	public void loadLastNames(ValuesFromDatabase valuesFromDatabase) {
		LoadLastNames lastNames = new LoadLastNames(valuesFromDatabase);
	}
	
	public void loadBirthdays(ValuesFromDatabase valuesFromDatabase) {
		LoadBirthdays birthdays = new LoadBirthdays(valuesFromDatabase);
	}
	
	public void loadEmails(ValuesFromDatabase valuesFromDatabase) {
		LoadEmails emails = new LoadEmails(valuesFromDatabase);
	}
	
	public void loadTelNrs(ValuesFromDatabase valuesFromDatabase) {
		LoadTelNrs telNrs = new LoadTelNrs(valuesFromDatabase);
	}
	
	public void loadDegrees(ValuesFromDatabase valuesFromDatabase) {
		LoadDegrees degrees = new LoadDegrees(valuesFromDatabase);
	}
	
	public void loadMeetingDays(ValuesFromDatabase valuesFromDatabase) {
		LoadMeetingDays meetingDays = new LoadMeetingDays(valuesFromDatabase);
	}
	
	public void loadGenders(ValuesFromDatabase valuesFromDatabase) {
		LoadGenders genders = new LoadGenders(valuesFromDatabase);
	}
	
	public void loadWholeDatabase() {
		LoadWholeDatabase wholeDatabase = new LoadWholeDatabase();
	}
	
	public void loadWholeTableView(TableView<TableModel> tableView, TableColumn<TableModel, String> firstNameColumn, TableColumn<TableModel, String> lastNameColumn,
			TableColumn<TableModel, String> birthdayColumn, TableColumn<TableModel, String> emailColumn, TableColumn<TableModel, String> telephoneColumn,
			TableColumn<TableModel, String> degreeColumn, TableColumn<TableModel, String> meetingDayColumn, TableColumn<TableModel, String> genderColumn) {
		LoadWholeTableView wholeTableView = new LoadWholeTableView();
		wholeTableView.loadWholeTableView(tableView, firstNameColumn, lastNameColumn, birthdayColumn, emailColumn, telephoneColumn, degreeColumn, meetingDayColumn, genderColumn, searchModelObservableList);
	}
	
}
