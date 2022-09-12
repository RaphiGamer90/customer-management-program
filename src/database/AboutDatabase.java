package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;



public class AboutDatabase {

	
	//Row Count
	public int getRowsCount() {
		int rowCount = 0;
		try {
			ResultSet rs = ConnectionToDatabase.preparedStatement("SELECT COUNT(*) FROM customers").executeQuery();
			rs.next();
			rowCount = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("ROWS COUNT");
			e.printStackTrace();
		}
		return rowCount;
	}
	
	//Column Count
	public int getColumnsCount() {
		int columnCount = 0;
		try {
			ResultSet rs = ConnectionToDatabase.preparedStatement("SELECT * FROM customers").executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			columnCount = rsMetaData.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return columnCount;
	}
	
	//Column Names
	public ArrayList<String> getColumnNames() {
		ArrayList<String> columnNames = new ArrayList<>();
		try {
			ResultSet rs = ConnectionToDatabase.preparedStatement("SELECT * FROM customers").executeQuery();
			 ResultSetMetaData rsMetaData = rs.getMetaData();
	            for (int colNum = 1; colNum <= getColumnsCount(); colNum++) {
	            	columnNames.add(rsMetaData.getColumnLabel(colNum));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return columnNames;
	}
}
