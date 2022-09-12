package manager.loading.dataFromDatabase;

import java.sql.SQLException;

import database.DataFromDatabase;

public interface LoadLastNames {
	
	default public void loadlastnames(DataFromDatabase lastNames) {		
		lastNames.lastNamesFromDatabase();
	}
}
