package database;

import java.sql.SQLException;

import database.ConnectionToDatabase;

public class DeleteFromDatabase {

	public void deleteValueFromDatabase(String delete) {
		
		String query = "DELETE FROM customers WHERE Email='" + delete + "';"; 		
		
		try {
			ConnectionToDatabase.preparedStatement(query).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
