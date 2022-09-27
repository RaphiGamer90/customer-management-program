package manager.loading;

import java.sql.SQLException;

import controllers.MainController;
import database.AboutDatabase;
import database.DataFromDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import manager.data.DataManager;
import manager.models.TableModel;

public class LoadManager extends DataFromDatabase {
	
	/*Load everything from the Database*/
	public void loadFirstNames() {
		firstNamesFromDatabase();
	}
	
	public void loadLastNames() {
		lastNamesFromDatabase();
	}
	
	public void loadBirthdays() {
		birthdaysFromDatabase();
	}
	
	public void loadEmails() {
		emailsFromDatabase();
	}
	
	public void loadTelNrs() {
		telNrFromDatabase();
	}
	
	public void loadDegrees() {
		degreesFromDatabase();
	}
	
	public void loadMeetingDays() {
		meetingDaysFromDatabase();
	}
	
	public void loadGenders() {
		gendersFromDatabase();
	}
	
	public void loadWholeDatabase() {
		initialiseAllLists();
	}

}
