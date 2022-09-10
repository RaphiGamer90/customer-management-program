package manager.loading.dataFromDatabase;

import database.ValuesFromDatabase;

public interface LoadFirstNames {
	
	 default public void loadfirstnames(ValuesFromDatabase firstNames) {
		firstNames.firstNamesFromDatabase();		
	}
}
