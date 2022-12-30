package controllers.actions;

import controllers.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import manager.models.TableModel;

public class SearchFilter {

	Controller controller = new Controller();

	/*
	 * Suchen bestimmter String-Werte in der TableView
	 * */
	public void searchFilter() {

		FilteredList<TableModel> filteredData = new FilteredList<>(
				controller.getMainController().tableManager.searchModelObservableList, b -> true);
		controller.getMainController().searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(searchModel -> {
				if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
					return true;
				}
				String searchKeyword = newValue.toLowerCase();

				if (controller.getMainController().searchBox.getValue() == null || controller.getMainController().searchBox.getValue() == "Alle") {
					if (searchModel.getFirstName().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					} else if (searchModel.getLastName().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					} else if (searchModel.getBirthday().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					} else if (searchModel.getEmail().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					} else if (searchModel.getTelNr().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					} else if (searchModel.getDegree().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					} else if (searchModel.getMeetingDay().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					} else if (searchModel.getGender().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}

				}
				else {
					switch (controller.getMainController().searchBox.getValue()) {
						case "Vorname":
							if (searchModel.getFirstName().toLowerCase().indexOf(searchKeyword) != -1) { return true; }
							break;
						case "Nachname": 
							if (searchModel.getLastName().toLowerCase().indexOf(searchKeyword) != -1) { return true; }
							break;
						case "Geburtstag": 
							if (searchModel.getBirthday().toLowerCase().indexOf(searchKeyword) != -1) { return true; }
							break;
						case "E-Mail": 
							if (searchModel.getEmail().toLowerCase().indexOf(searchKeyword) != -1) { return true; }
							break;
						case "Telefonnummer": 
							if (searchModel.getTelNr().toLowerCase().indexOf(searchKeyword) != -1) { return true; }
							break;
						case "Titel": 
							if (searchModel.getDegree().toLowerCase().indexOf(searchKeyword) != -1) { return true; }
							break;
						case "Auftrag Datum": 
							if (searchModel.getMeetingDay().toLowerCase().indexOf(searchKeyword) != -1) { return true; }
							break;
						case "Geschlecht": 
							if (searchModel.getGender().toLowerCase().indexOf(searchKeyword) != -1) { return true; }
							break;
						default:
							break;
					}
				}
				return false;
			});

			SortedList<TableModel> sortedData = new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(controller.getMainController().tableView.comparatorProperty());
			controller.getMainController().tableView.setItems(sortedData);

			controller.getMainController().searchOutputField.setText(controller.getMainController().tableView.getItems().size() + "");
		});
		
	}

}
