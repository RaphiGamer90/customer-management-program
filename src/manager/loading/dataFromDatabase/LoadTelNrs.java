package manager.loading.dataFromDatabase;

import java.util.ArrayList;

import database.ValuesFromDatabase;

public class LoadTelNrs {

	ValuesFromDatabase telNrs = new ValuesFromDatabase();
	
	public LoadTelNrs() {
		telNrs.telNrFromDatabase();
	}
	
	public ArrayList<String> getLoadetTelNrs() {
		return telNrs.getTelNrFromDatabase();
	}
}
