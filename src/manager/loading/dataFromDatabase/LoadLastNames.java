package manager.loading.dataFromDatabase;

import database.ValuesFromDatabase;

public interface LoadLastNames {
	
	default public void loadlastnames(ValuesFromDatabase lastNames) {		
		lastNames.lastNamesFromDatabase();
	}
}
