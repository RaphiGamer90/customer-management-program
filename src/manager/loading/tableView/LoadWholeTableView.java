package manager.loading.tableView;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionToDatabase;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.cellFactory.CellFactory;
import manager.models.TableModel;

public class LoadWholeTableView {
	CellFactory cellFactory = new CellFactory();
	

	public void loadWholeTableView(TableView<TableModel> tableView, TableColumn<TableModel, String> firstNameColumn, TableColumn<TableModel, String> lastNameColumn,
			TableColumn<TableModel, String> birthdayColumn, TableColumn<TableModel, String> emailColumn, TableColumn<TableModel, String> telephoneColumn,
			TableColumn<TableModel, String> titleColumn, TableColumn<TableModel, String> orderDateColumn, TableColumn<TableModel, String> genderColumn, 
			ObservableList<TableModel> searchModelObservableList) {
		
		String query = "SELECT * From customers";
		try {
			
			ResultSet queryOutput = ConnectionToDatabase.preparedStatement(query).executeQuery();
			while (queryOutput.next()) {

				String firstName = queryOutput.getString("Vorname");
				String lastName = queryOutput.getString("Nachname");
				String birthday = queryOutput.getString("Geburtstag");
				String email = queryOutput.getString("Email");
				String telephonenumber = queryOutput.getString("Telefonnummer");
				String titel = queryOutput.getString("Titel");
				String orderDate = queryOutput.getString("AuftragDatum");
				String gender = queryOutput.getString("Geschlecht");

				searchModelObservableList.add(new TableModel(firstName, lastName, birthday, email, telephonenumber, titel, orderDate, gender));
			}
		} catch (SQLException e) {
			System.out.println("EIN SQL FEHLER WURDE GESCHMISSEN");
			e.printStackTrace();
		}
		
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telNr"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("meetingDay"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
		
		firstNameColumn.setCellFactory(cellFactory.cellFactoryForMap);
		lastNameColumn.setCellFactory(cellFactory.cellFactoryForMap);
		birthdayColumn.setCellFactory(cellFactory.cellFactoryForMap);
		emailColumn.setCellFactory(cellFactory.cellFactoryForMap);
		telephoneColumn.setCellFactory(cellFactory.cellFactoryForMap);
		titleColumn.setCellFactory(cellFactory.cellFactoryForMap);
		orderDateColumn.setCellFactory(cellFactory.cellFactoryForMap);
		genderColumn.setCellFactory(cellFactory.cellFactoryForMap);

		tableView.setItems(searchModelObservableList);
		System.out.println("Es wurde die TableView geladen!");
	}
}
