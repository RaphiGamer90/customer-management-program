package manager.loading.dataFromDatabase;

import java.util.ArrayList;

import database.DataFromDatabase;

public interface LoadTelNrs {
	
	default public void loadtelnrs(DataFromDatabase telNrs) {		
		telNrs.telNrFromDatabase();
	}
}
