package manager.filter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import manager.models.TableModel;

public class SearchFilter {
	
	
	public void searchFilter(TableView<TableModel> tableView, TextField searchField, ComboBox<String> searchFor, TextField searchFieldOutput, 
			ObservableList<TableModel> searchModelObservableList) {
		
		FilteredList<TableModel> filteredData = new FilteredList<>(searchModelObservableList, b -> true);
		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(searchModel -> {
				if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
					return true;
				}
				String searchKeyword = newValue.toLowerCase();
				
				if(searchFor.getValue() == null || searchFor.getValue() == "Alle") {
					if(searchModel.getFirstName().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}	
					else if(searchModel.getLastName().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					else if(searchModel.getBirthday().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					else if(searchModel.getEmail().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					else if(searchModel.getTelNr().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					else if(searchModel.getDegree().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					else if(searchModel.getMeetingDay().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					else if(searchModel.getGender().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					
				}
				else if(searchFor.getValue().equals("Vorname")) {
					if(searchModel.getFirstName().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					return false;
				}
				else if(searchFor.getValue().equals("Nachname")) {
					if(searchModel.getLastName().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					return false;
				}
				else if(searchFor.getValue().equals("Geburtstag")) {
					if(searchModel.getBirthday().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					return false;
				}
				else if(searchFor.getValue().equals("E-Mail")) {
					if(searchModel.getEmail().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					return false;
				}
				else if(searchFor.getValue().equals("Telefonnummer")) {
					if(searchModel.getTelNr().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					return false;
				}
				else if(searchFor.getValue().equals("Titel")) {
					if(searchModel.getDegree().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					return false;
				}
				else if(searchFor.getValue().equals("Auftrag Datum")) {
					if(searchModel.getMeetingDay().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					return false;
				}
				else if(searchFor.getValue().equals("Geschlecht")) {
					if(searchModel.getGender().toLowerCase().indexOf(searchKeyword) != -1) {
						return true;
					}
					return false;
				}
				
				return false;
				
			});
			
			searchFieldOutput.setText(tableView.getItems().size() + "");
		});
		
		SortedList<TableModel> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
		
//		tableView.setItems(sortedData);
		
	}

}
