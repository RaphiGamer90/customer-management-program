package database;

import java.sql.SQLException;

import controllers.Controller;
import database.ConnectionToDatabase;

public class DeleteFromDatabase {

	Controller controller = new Controller();
	
	//Löschen nach E-Mails
	public void deleteValueFromDatabase(String delete) {
		
		String query = "DELETE FROM customers WHERE Email='" + delete + "';"; 		
		
		try {
			ConnectionToDatabase.preparedStatement(query).executeUpdate();
			controller.getMainController().tableManager.refreshWholeTableView();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
