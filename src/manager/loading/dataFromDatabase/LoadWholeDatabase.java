package manager.loading.dataFromDatabase;

import java.sql.SQLException;

import database.DataFromDatabase;

public class LoadWholeDatabase {
	
	public void loadWholeDatabase(DataFromDatabase wholeDatabase) throws SQLException  {
		wholeDatabase.initialiseAllLists();
	}
	
}
