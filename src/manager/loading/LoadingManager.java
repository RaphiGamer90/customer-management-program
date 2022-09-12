package manager.loading;

import java.sql.SQLException;

import database.DataFromDatabase;
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

public class LoadingManager implements LoadFirstNames, LoadLastNames, LoadBirthdays, LoadEmails, LoadTelNrs, LoadDegrees, LoadMeetingDays, LoadGenders {

	public void loadFirstNames(DataFromDatabase valuesFromDatabase) {
		loadfirstnames(valuesFromDatabase);
	}
	
	public void loadLastNames(DataFromDatabase valuesFromDatabase) {
		loadlastnames(valuesFromDatabase);
	}
	
	public void loadBirthdays(DataFromDatabase valuesFromDatabase) {
		loadbirthdays(valuesFromDatabase);
	}
	
	public void loadEmails(DataFromDatabase valuesFromDatabase) {
		loademails(valuesFromDatabase);
	}
	
	public void loadTelNrs(DataFromDatabase valuesFromDatabase) {
		loadtelnrs(valuesFromDatabase);
	}
	
	public void loadDegrees(DataFromDatabase valuesFromDatabase) {
		loaddegrees(valuesFromDatabase);
	}
	
	public void loadMeetingDays(DataFromDatabase valuesFromDatabase) {
		loadmeetingdays(valuesFromDatabase);
	}
	
	public void loadGenders(DataFromDatabase valuesFromDatabase) {
		loadgenders(valuesFromDatabase);
	}
	
	public void loadWholeDatabase(DataFromDatabase initAll) {
		initAll.initialiseAllLists();
	}
	
	
	
	public void loadFirstNameColumn() {
		
	}
	
}
