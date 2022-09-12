package manager.loading.tableView;

import database.AboutDatabase;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.cellFactory.CellFactory;
import manager.data.DataManager;
import manager.models.TableModel;

public class LoadGendersColumn {

	public void loadGenderColumn(TableView<TableModel> tableView, TableColumn<TableModel, String> firstNameColumn, TableColumn<TableModel, String> lastNameColumn,
			TableColumn<TableModel, String> birthdayColumn, TableColumn<TableModel, String> emailColumn, TableColumn<TableModel, String> telephoneColumn,
			TableColumn<TableModel, String> degreeColumn, TableColumn<TableModel, String> meetingDayColumn, TableColumn<TableModel, String> genderColumn, ObservableList<TableModel> searchModelObservableList, 
			AboutDatabase aboutDatabase, DataManager dataManager, CellFactory cellFactory) {
		searchModelObservableList.clear();
		
		for(int i = 0; i < aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(dataManager.getFirstNames().get(i), dataManager.getLastNames().get(i), dataManager.getBirthdays().get(i), 
					dataManager.getEmails().get(i), dataManager.getTelNrs().get(i), dataManager.getDegrees().get(i), dataManager.getMeetingDays().get(i), dataManager.getLoadedGenders().get(i)));			
		}
		
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
	
		cellFactory.setCellFactory(firstNameColumn, lastNameColumn, birthdayColumn, emailColumn, telephoneColumn, degreeColumn, meetingDayColumn, genderColumn);
		
		tableView.setItems(searchModelObservableList);
		System.out.println("Es wurde FirstNameColumn geladen!");
	}
}
