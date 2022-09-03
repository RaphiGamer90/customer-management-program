package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionToDatabase {

	private static Connection connection;
	
	String host = "localhost";
	int port = 3306;	
	String database = "customerdatabase";
	String username = "root";
	String password = "Winter90#"; 
	
    public void openConnection() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			return;
		}
		connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
	}
    
    
    public static void closeConnection() throws SQLException{
    	connection.close(); 
    }
    
	//Methode um ein Statement zurück zu geben
	public static PreparedStatement preparedStatement(String query) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
		
	}
}
