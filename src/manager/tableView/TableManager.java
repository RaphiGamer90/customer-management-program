package manager.tableView;

import controllers.MainController;
import database.AboutDatabase;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.cellFactory.CellFactory;
import manager.data.DataManager;
import manager.models.TableModel;

public class TableManager extends DataManager {
	
	MainController mainController = new MainController();
	CellFactory cellFactory = new CellFactory();
	AboutDatabase aboutDatabase = new AboutDatabase();
	
	public void refreshFirstNameColumn() {
		mainController.searchModelObservableList.clear();
		
		for(int i = 0; i < aboutDatabase.getRowsCount(); i++) {
			mainController.searchModelObservableList.add(new TableModel(getReloadedFirstNames().get(i), getUnloadedLastNames().get(i), getUnloadedBirthdays().get(i), 
					getUnloadedEmails().get(i), getUnloadedTelNrs().get(i), getUnloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getUnloadedGenders().get(i)));			
		}
		
		mainController.getFirstNameColumn().setCellValueFactory(new PropertyValueFactory<>("firstName"));
		mainController.getLastNameColumn().setCellValueFactory(new PropertyValueFactory<>("lastName"));
		mainController.getBirthdayColumn().setCellValueFactory(new PropertyValueFactory<>("birthday"));
		mainController.getEmailColumn().setCellValueFactory(new PropertyValueFactory<>("email"));
		mainController.getTelephoneColumn().setCellValueFactory(new PropertyValueFactory<>("telNr"));
		mainController.getDegreeColumn().setCellValueFactory(new PropertyValueFactory<>("degree"));
		mainController.getMeetingDayColumn().setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		mainController.getGenderColumn().setCellValueFactory(new PropertyValueFactory<>("gender"));
	
		cellFactory.setCellFactory(mainController.getFirstNameColumn(), mainController.getLastNameColumn(), mainController.getBirthdayColumn(), mainController.getEmailColumn(), mainController.getTelephoneColumn(),
				mainController.getDegreeColumn(), mainController.getMeetingDayColumn(), mainController.getGenderColumn());
		
		mainController.getTableView().setItems(mainController.searchModelObservableList);
	}
	
}
