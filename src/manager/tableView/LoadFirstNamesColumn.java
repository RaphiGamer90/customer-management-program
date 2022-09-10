package manager.tableView;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionToDatabase;
import database.ValuesFromDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.cellFactory.CellFactory;
import manager.loading.MainLoadingManager;
import manager.models.TableModel;

public class LoadFirstNamesColumn {

//	public void loadFirstNamesColumnn(TableView<TableModel> tableView, TableColumn<TableModel, String> firstNameColumn, 
//			CellFactory cellFactory, ObservableList<TableModel> searchModelObservableList, MainLoadingManager loadingManager, ValuesFromDatabase firstNames) {
//		
//		loadingManager.loadFirstNames(firstNames);
//		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//		firstNameColumn.setCellFactory(cellFactory.cellFactoryForMap);
//
//		tableView.setItems(searchModelObservableList);
//		System.out.println("Es wurde FirstName Column neu geladen!");
//	}
	
}
