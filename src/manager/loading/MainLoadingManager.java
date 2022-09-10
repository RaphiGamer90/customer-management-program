package manager.loading;

import database.ValuesFromDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import manager.cellFactory.CellFactory;
import manager.loading.dataFromDatabase.LoadBirthdays;
import manager.loading.dataFromDatabase.LoadDegrees;
import manager.loading.dataFromDatabase.LoadEmails;
import manager.loading.dataFromDatabase.LoadFirstNames;
import manager.loading.dataFromDatabase.LoadGenders;
import manager.loading.dataFromDatabase.LoadLastNames;
import manager.loading.dataFromDatabase.LoadMeetingDays;
import manager.loading.dataFromDatabase.LoadTelNrs;
import manager.loading.dataFromDatabase.LoadWholeDatabase;
import manager.models.TableModel;

public class MainLoadingManager implements LoadFirstNames, LoadLastNames, LoadBirthdays, LoadEmails, LoadTelNrs, LoadDegrees, LoadMeetingDays, LoadGenders {

	public void loadFirstNames(ValuesFromDatabase valuesFromDatabase) {
		loadfirstnames(valuesFromDatabase);
	}
	
	public void loadLastNames(ValuesFromDatabase valuesFromDatabase) {
		loadlastnames(valuesFromDatabase);
	}
	
	public void loadBirthdays(ValuesFromDatabase valuesFromDatabase) {
		loadbirthdays(valuesFromDatabase);
	}
	
	public void loadEmails(ValuesFromDatabase valuesFromDatabase) {
		loademails(valuesFromDatabase);
	}
	
	public void loadTelNrs(ValuesFromDatabase valuesFromDatabase) {
		loadtelnrs(valuesFromDatabase);
	}
	
	public void loadDegrees(ValuesFromDatabase valuesFromDatabase) {
		loaddegrees(valuesFromDatabase);
	}
	
	public void loadMeetingDays(ValuesFromDatabase valuesFromDatabase) {
		loadmeetingdays(valuesFromDatabase);
	}
	
	public void loadGenders(ValuesFromDatabase valuesFromDatabase) {
		loadgenders(valuesFromDatabase);
	}
	
	public void loadWholeDatabase(ValuesFromDatabase initAll) {
		initAll.initialiseAllLists();
	}
	
}
