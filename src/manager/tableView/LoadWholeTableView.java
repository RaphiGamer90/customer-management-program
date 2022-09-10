package manager.tableView;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionToDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.cellFactory.CellFactory;
import manager.data.DataManager;
import manager.loading.MainLoadingManager;
import manager.models.TableModel;

public class LoadWholeTableView {
	CellFactory cellFactory = new CellFactory();
	

	public void loadWholeTableView(TableView<TableModel> tableView, TableColumn<TableModel, String> firstNameColumn, TableColumn<TableModel, String> lastNameColumn,
			TableColumn<TableModel, String> birthdayColumn, TableColumn<TableModel, String> emailColumn, TableColumn<TableModel, String> telephoneColumn,
			TableColumn<TableModel, String> degreeColumn, TableColumn<TableModel, String> meetingDayColumn, TableColumn<TableModel, String> genderColumn, ObservableList<TableModel> searchModelObservableList) {
		
		
		
		
		DataManager dataManager = new DataManager();
		searchModelObservableList = FXCollections.observableArrayList();
		searchModelObservableList.clear();
		for(int i = 0; i < 5; i++) {
			searchModelObservableList.add(new TableModel(dataManager.getFirstNames().get(i), dataManager.getLastNames().get(i), dataManager.getBirthdays().get(i), 
					dataManager.getEmails().get(i), dataManager.getTelNrs().get(i), dataManager.getDegrees().get(i), dataManager.getMeetingDays().get(i), dataManager.getGenders().get(i)));			
		}
		
	
		
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
		
		firstNameColumn.setCellFactory(cellFactory.cellFactoryForMap);
		lastNameColumn.setCellFactory(cellFactory.cellFactoryForMap);
		birthdayColumn.setCellFactory(cellFactory.cellFactoryForMap);
		emailColumn.setCellFactory(cellFactory.cellFactoryForMap);
		telephoneColumn.setCellFactory(cellFactory.cellFactoryForMap);
		degreeColumn.setCellFactory(cellFactory.cellFactoryForMap);
		meetingDayColumn.setCellFactory(cellFactory.cellFactoryForMap);
		genderColumn.setCellFactory(cellFactory.cellFactoryForMap);

		tableView.setItems(searchModelObservableList);
		System.out.println("Es wurde die TableView geladen!");
	}
}
