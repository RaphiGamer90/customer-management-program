package manager.loading.dataFromDatabase;

import java.sql.SQLException;

import database.DataFromDatabase;

public interface LoadFirstNames {
	
	 default public void loadfirstnames(DataFromDatabase firstNames) {
		firstNames.firstNamesFromDatabase();		
	}
}
