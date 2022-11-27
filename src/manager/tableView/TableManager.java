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
import manager.data.DataManager;
import manager.models.TableModel;

public class TableManager extends DataManager {

	Controller controller = new Controller();

	public ObservableList<TableModel> searchModelObservableList = FXCollections.observableArrayList();

	/*
	 * FirstName Column gets refreshed
	 * 
	 */
	public void refreshFirstNameColumn() {
		searchModelObservableList.clear();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getReloadedFirstNames().get(i), getUnloadedLastNames().get(i),
					getUnloadedBirthdays().get(i), getUnloadedEmails().get(i), getUnloadedTelNrs().get(i),
					getUnloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getUnloadedGenders().get(i)));
		}
		
		controller.getMainController().cellFactoryManager.setCellFactory(controller.getMainController().firstNameColumn,
				controller.getMainController().lastNameColumn, controller.getMainController().birthdayColumn,
				controller.getMainController().emailColumn, controller.getMainController().telephoneColumn,
				controller.getMainController().degreeColumn, controller.getMainController().meetingDayColumn,
				controller.getMainController().genderColumn);
		controller.getMainController().tableView.setItems(searchModelObservableList);
	}

	/*
	 * LastName Column gets refreshed
	 * 
	 */
	public void refreshLastNameColumn() {
		searchModelObservableList.clear();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getUnloadedFirstNames().get(i), getReloadedLastNames().get(i),
					getUnloadedBirthdays().get(i), getUnloadedEmails().get(i), getUnloadedTelNrs().get(i),
					getUnloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getUnloadedGenders().get(i)));
		}

		controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		controller.getMainController().cellFactoryManager.setCellFactory(controller.getMainController().firstNameColumn,
				controller.getMainController().lastNameColumn, controller.getMainController().birthdayColumn,
				controller.getMainController().emailColumn, controller.getMainController().telephoneColumn,
				controller.getMainController().degreeColumn, controller.getMainController().meetingDayColumn,
				controller.getMainController().genderColumn);
		controller.getMainController().tableView.setItems(searchModelObservableList);
	}

	/*
	 * Email Column gets refreshed
	 * 
	 */
	public void refreshEmailColumn() {
		searchModelObservableList.clear();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getUnloadedFirstNames().get(i), getUnloadedLastNames().get(i),
					getUnloadedBirthdays().get(i), getReloadedEmails().get(i), getUnloadedTelNrs().get(i),
					getUnloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getUnloadedGenders().get(i)));
		}

		controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		controller.getMainController().cellFactoryManager.setCellFactory(controller.getMainController().firstNameColumn,
				controller.getMainController().lastNameColumn, controller.getMainController().birthdayColumn,
				controller.getMainController().emailColumn, controller.getMainController().telephoneColumn,
				controller.getMainController().degreeColumn, controller.getMainController().meetingDayColumn,
				controller.getMainController().genderColumn);
		controller.getMainController().tableView.setItems(searchModelObservableList);
	}

	/*
	 * Telephone Number Column gets refreshed
	 * 
	 */
	public void refreshTelNrColumn() {
		searchModelObservableList.clear();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getUnloadedFirstNames().get(i), getUnloadedLastNames().get(i),
					getUnloadedBirthdays().get(i), getUnloadedEmails().get(i), getReloadedTelNrs().get(i),
					getUnloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getUnloadedGenders().get(i)));
		}

		controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		controller.getMainController().cellFactoryManager.setCellFactory(controller.getMainController().firstNameColumn,
				controller.getMainController().lastNameColumn, controller.getMainController().birthdayColumn,
				controller.getMainController().emailColumn, controller.getMainController().telephoneColumn,
				controller.getMainController().degreeColumn, controller.getMainController().meetingDayColumn,
				controller.getMainController().genderColumn);
		controller.getMainController().tableView.setItems(searchModelObservableList);
	}

	/*
	 * Degree Column gets refreshed
	 * 
	 */
	public void refreshDegreeColumn() {
		searchModelObservableList.clear();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getUnloadedFirstNames().get(i), getUnloadedLastNames().get(i),
					getUnloadedBirthdays().get(i), getUnloadedEmails().get(i), getUnloadedTelNrs().get(i),
					getReloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getUnloadedGenders().get(i)));
		}

		controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		controller.getMainController().cellFactoryManager.setCellFactory(controller.getMainController().firstNameColumn,
				controller.getMainController().lastNameColumn, controller.getMainController().birthdayColumn,
				controller.getMainController().emailColumn, controller.getMainController().telephoneColumn,
				controller.getMainController().degreeColumn, controller.getMainController().meetingDayColumn,
				controller.getMainController().genderColumn);
		controller.getMainController().tableView.setItems(searchModelObservableList);
	}

	/*
	 * Meeting Day Column gets refreshed
	 * 
	 */
	public void refreshMeetingDayColumn() {
		searchModelObservableList.clear();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getUnloadedFirstNames().get(i), getUnloadedLastNames().get(i),
					getUnloadedBirthdays().get(i), getUnloadedEmails().get(i), getUnloadedTelNrs().get(i),
					getUnloadedDegrees().get(i), getReloadedMeetingDays().get(i), getUnloadedGenders().get(i)));
		}

		controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		controller.getMainController().cellFactoryManager.setCellFactory(controller.getMainController().firstNameColumn,
				controller.getMainController().lastNameColumn, controller.getMainController().birthdayColumn,
				controller.getMainController().emailColumn, controller.getMainController().telephoneColumn,
				controller.getMainController().degreeColumn, controller.getMainController().meetingDayColumn,
				controller.getMainController().genderColumn);
		controller.getMainController().tableView.setItems(searchModelObservableList);
	}

	/*
	 * Gender Column gets refreshed
	 * 
	 */
	public void refreshBirthdayColumn() {
		searchModelObservableList.clear();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getUnloadedFirstNames().get(i), getUnloadedLastNames().get(i),
					getUnloadedBirthdays().get(i), getUnloadedEmails().get(i), getUnloadedTelNrs().get(i),
					getUnloadedDegrees().get(i), getUnloadedMeetingDays().get(i), getReloadedGenders().get(i)));
		}

		controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		controller.getMainController().cellFactoryManager.setCellFactory(controller.getMainController().firstNameColumn,
				controller.getMainController().lastNameColumn, controller.getMainController().birthdayColumn,
				controller.getMainController().emailColumn, controller.getMainController().telephoneColumn,
				controller.getMainController().degreeColumn, controller.getMainController().meetingDayColumn,
				controller.getMainController().genderColumn);
		controller.getMainController().tableView.setItems(searchModelObservableList);
	}

	/*
	 * All Columns get refreshed
	 * 
	 */
	public void refreshWholeTableView() {
		searchModelObservableList.clear();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			searchModelObservableList.add(new TableModel(getReloadedFirstNames().get(i), getReloadedLastNames().get(i),
					getReloadedBirthdays().get(i), getReloadedEmails().get(i), getReloadedTelNrs().get(i),
					getReloadedDegrees().get(i), getReloadedMeetingDays().get(i), getReloadedGenders().get(i)));
		}

		controller.getMainController().firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		controller.getMainController().lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		controller.getMainController().birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		controller.getMainController().emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		controller.getMainController().telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		controller.getMainController().degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		controller.getMainController().meetingDayColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		controller.getMainController().genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

		controller.getMainController().cellFactoryManager.setCellFactory(controller.getMainController().firstNameColumn,
				controller.getMainController().lastNameColumn, controller.getMainController().birthdayColumn,
				controller.getMainController().emailColumn, controller.getMainController().telephoneColumn,
				controller.getMainController().degreeColumn, controller.getMainController().meetingDayColumn,
				controller.getMainController().genderColumn);
		controller.getMainController().tableView.setItems(searchModelObservableList);
	}

}
