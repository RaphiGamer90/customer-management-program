package manager.tableView;

import controllers.MainController;
import database.AboutDatabase;
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
	

	public void refreshFirstNameColumn() { 
		MainController.getMainController().getFirstNameColumn();
//		mainController.searchModelObservableList.clear();
//
//		for (int i = 0; i < aboutDatabase.getRowsCount(); i++) {
//			mainController.searchModelObservableList
//					.add(new TableModel(getReloadedFirstNames().get(i), getUnloadedLastNames().get(i),
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

//		cellFactory.setCellFactory(MainController.firstNameColumn, mainController.getLastNameColumn(),
//				mainController.getBirthdayColumn(), mainController.getEmailColumn(),
//				mainController.getTelephoneColumn(), mainController.getDegreeColumn(),
//				mainController.getMeetingDayColumn(), mainController.getGenderColumn());
//
//		mainController.getTableView().setItems(mainController.searchModelObservableList);
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
		
		
		MainController.searchModelObservableList.clear();

		for (int i = 0; i < aboutDatabase.getRowsCount(); i++) {
			MainController.searchModelObservableList
					.add(new TableModel(getReloadedFirstNames().get(i), getReloadedLastNames().get(i),
							getReloadedBirthdays().get(i), getReloadedEmails().get(i), getReloadedTelNrs().get(i),
							getReloadedDegrees().get(i), getReloadedMeetingDays().get(i), getReloadedGenders().get(i)));
		}

		MainController.firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		MainController.lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		MainController.birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		MainController.emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		MainController.telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		MainController.degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		MainController.meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		MainController.genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		cellFactory.setCellFactory(MainController.firstNameColumn, MainController.lastNameColumn,
				MainController.birthdayColumn, MainController.emailColumn,
				MainController.telephoneColumn, MainController.degreeColumn,
				MainController.meetingDayColumn, MainController.genderColumn);

		MainController.tableView.setItems(MainController.searchModelObservableList);

	}

}
