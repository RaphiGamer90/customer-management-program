package manager.loading.dataFromDatabase;

import java.util.ArrayList;

import database.ValuesFromDatabase;

public interface LoadTelNrs {
	
	default public void loadtelnrs(ValuesFromDatabase telNrs) {		
		telNrs.telNrFromDatabase();
	}
}
