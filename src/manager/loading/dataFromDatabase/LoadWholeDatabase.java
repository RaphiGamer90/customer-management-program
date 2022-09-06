package manager.loading.dataFromDatabase;

import database.ValuesFromDatabase;

public class LoadWholeDatabase {

	ValuesFromDatabase wholeDatabase = new ValuesFromDatabase();
	
	public void loadWholeDatabase() {
		wholeDatabase.initialiseAllLists();
	}
	
}
