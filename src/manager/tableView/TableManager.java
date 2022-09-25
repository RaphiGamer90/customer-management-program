package manager.tableView;

import controllers.Controller;
import controllers.MainController;
import database.AboutDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.cellFactory.CellFactory;
import manager.data.DataManager;
import manager.models.TableModel;

public class TableManager extends DataManager {

	CellFactory cellFactory = new CellFactory();
	AboutDatabase aboutDatabase = new AboutDatabase();
	
	public ObservableList<TableModel> searchModelObservableList = FXCollections.observableArrayList();
	
	
	public void refreshFirstNameColumn() { 
		
		searchModelObservableList.clear();

		for (int i = 0; i < aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList
					.add(new TableModel(getReloadedFirstNames().get(i), getUnloadedLastNames().get(i),
							getUnloadedBirthdays().get(i), getUnloadedEmails().get(i), getUnloadedTelNrs().get(i),
							getUnloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getUnloadedGenders().get(i)));
		}

//		Controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//		Controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//		Controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
//		Controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//		Controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
//		Controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
//		Controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
//		Controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		cellFactory.setCellFactory(Controller.getMainController().firstNameColumn, Controller.getMainController().lastNameColumn,
				Controller.getMainController().birthdayColumn, Controller.getMainController().emailColumn,
				Controller.getMainController().telephoneColumn, Controller.getMainController().degreeColumn,
				Controller.getMainController().meetingDayColumn, Controller.getMainController().genderColumn);
		Controller.getMainController().tableView.setItems(searchModelObservableList);
	}

	public void refreshLastNameColumn() {
//		mainController.searchModelObservableList.clear();
//
//		for (int i = 0; i < aboutDatabase.getRowsCount(); i++) {
//			mainController.searchModelObservableList
//					.add(new TableModel(getUnloadedFirstNames().get(i), getReloadedLastNames().get(i),
//							getUnloadedBirthdays().get(i), getUnloadedEmails().get(i), getUnloadedTelNrs().get(i),
//							getUnloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getUnloadedGenders().get(i)));
//		}

//		mainController.getFirstNameColumn().setCellValueFactory(new PropertyValueFactory<>("firstName"));
//		mainController.getLastNameColumn().setCellValueFactory(new PropertyValueFactory<>("lastName"));
//		mainController.getBirthdayColumn().setCellValueFactory(new PropertyValueFactory<>("birthday"));
//		mainController.getEmailColumn().setCellValueFactory(new PropertyValueFactory<>("email"));
//		mainController.getTelephoneColumn().setCellValueFactory(new PropertyValueFactory<>("telNr"));
//		mainController.getDegreeColumn().setCellValueFactory(new PropertyValueFactory<>("degree"));
//		mainController.getMeetingDayColumn().setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
//		mainController.getGenderColumn().setCellValueFactory(new PropertyValueFactory<>("gender"));

//		cellFactory.setCellFactory(mainController.getFirstNameColumn(), mainController.getLastNameColumn(),
//				mainController.getBirthdayColumn(), mainController.getEmailColumn(),
//				mainController.getTelephoneColumn(), mainController.getDegreeColumn(),
//				mainController.getMeetingDayColumn(), mainController.getGenderColumn());
//
//		mainController.getTableView().setItems(mainController.searchModelObservableList);
	}

	public void refreshWholeTableView() {
		searchModelObservableList.clear();

		for (int i = 0; i < aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getReloadedFirstNames().get(i), getReloadedLastNames().get(i),
							getReloadedBirthdays().get(i), getReloadedEmails().get(i), getReloadedTelNrs().get(i),
							getReloadedDegrees().get(i), getReloadedMeetingDays().get(i), getReloadedGenders().get(i)));
		}

		Controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		Controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		Controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		Controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		Controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		Controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		Controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		Controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		cellFactory.setCellFactory(Controller.getMainController().firstNameColumn, Controller.getMainController().lastNameColumn,
				Controller.getMainController().birthdayColumn, Controller.getMainController().emailColumn,
				Controller.getMainController().telephoneColumn, Controller.getMainController().degreeColumn,
				Controller.getMainController().meetingDayColumn, Controller.getMainController().genderColumn);
		Controller.getMainController().tableView.setItems(searchModelObservableList);
		System.out.println("TableView geladen!");

	}

}
